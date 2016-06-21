# How to install camel-jms-eap-ose

The camel-jms-eap-ose app consists of a set of microservices, either packaged as Docker containers or as a standalone Camel Boot service.

## Prerequisites

The following prerequisites installations are required for this demo:

You should probably set up the basic developer tools to be able to go through these steps, examples. We will also cover more ideal workflows with developer-local setup of docker and openshift, so would be good to install the "optional" tools as well!

- Install JBoss Developer Studio 9.1.0 GA [https://www.jboss.org/products/devstudio.html]
- Install Apache Maven 3.2.x [http://maven.apache.org]
- Install JBoss EAP 6.4.0 [http://www.jboss.org/products/eap/overview/]
- Install OpenShift CDK [http://developers.redhat.com/products/cdk/overview/]

## Create new OpenShift project
For this demo, we'll want to create a new OpenShift project and install all of the camel-jms-eap-ose app microservices there.

> oc new-project camel-jms-eap-ose

## Setup Jboss EAP

1. Copy the standalone-full.xml file found in src/configuration to your <jboss eap install dir>/standalone/configuration directory
2. Startup EAP

> bin/standalone.sh -c standalone-full.xml

## Install AMQ 

The microservices in this project communicate over JMS and use JBoss AMQ. To do this, we should boot up a broker in the `camel-jms-eap-ose app` project. In the src/json directory of this project, we have a created an `amq.json` file that contains the broker.

1. SSH to the vagrant image hosting the OSE CDK
2. Via the vagrant SSH shell:

> oc login -u system:admin https://10.0.2.15:8443

3. Copy the amq.json file over to the vagrant image
4. Run the following command via the vagrant SSH shell:

> oc create -f amq.json

5. Via the OSE web console, monitor the startup of the AMQ pod to ensure it starts correctly

## Install a PersistentVolume
The way Kubernetes works, if you want to store data to the file system in a persistent way, you can mount [Volumes](http://kubernetes.io/v1.1/docs/user-guide/volumes.html) and use [PersistentVolumeClaims](http://kubernetes.io/v1.1/docs/user-guide/persistent-volumes.html) to attach a pod to a volume. Above, we created the PersistentVolumeClaim using the type-safe DSL builders, but before we can spin up the app to use the PersistentVolumeClaim, we need to first establish a PersistentVolume. In general, only cluster admins or project admins will be able to administer the management of PersistentVolumes. 
 
The PersistentVolume definition is located at [src/json/vagrant-pv.yaml](src/json/vagrant-pv.yaml) and looks like this:

```
kind: PersistentVolume
apiVersion: v1
metadata:
  name: camel-router-file-pv
  labels:
    type: local
spec:
  capacity:
    storage: 100Ki
  accessModes:
    - ReadWriteOnce
  persistentVolumeReclaimPolicy: Recycle
  hostPath:
    path: "/opt/camel"
```


So as an cluster or project admin user, you can run the following to create the PersistentVolume:

> oc create -f vagrant-pv.yaml

  Note: as a user of the CDK, you can achieve cluster-admin rights by using the config file in /var/lib/origin/openshift.local.config/master/admin.kubeconfig. If you copy this to your ~/.kube/config file or set the location to it in $KUBECONFIG environment variable, you should be granted full cluster-admin rights and should be able to create PVs.  It is best to first login to the vagrant from your host machine:
  
  > vagrant ssh
  
  Then sudo to root
  
  > sudo -s
  
  Then login to OpenShift using the "system:admin" superuser on a dedicated admin interface (10.0.2.15):
  
  > oc login -u system:admin https://10.0.2.15:8443
  
  Now you can create the PersistentVolume by running the following command:
  
  > oc create -f vagrant-pv.yaml
  
After you've created the PersistentVolume, you should be able to verify:

```
NAME                   LABELS       CAPACITY     ACCESSMODES   STATUS      CLAIM     REASON
camel-router-file-pv   type=local   102400       RWO           Available             
```

Now we can deploy our app and expect the Claim to be satisfied. Note, in this example, we're using a HostVolume, but in practice that is not advisable.
  
We can take that json and "apply" it to a running OpenShift installation. Note that for this plugin to work, you must
already be logged into openshift with `oc login` and have the following environment variable set:

```
  export KUBERNETES_MASTER=https://10.1.2.2:8443
  export KUBERNETES_DOMAIN=
  export KUBERNETES_TRUST_CERT=true
```
  
Then you should be able to run the following maven command to deploy:

> $  mvn clean install -Pfabric8 -Pkube-generate fabric8:apply

Note for this to work, you must have run the `docker:build` previously. Or you can combine all of them:

> $  mvn clean install -Pfabric8 -Phawtapp -Pkube-generate docker:build fabric8:apply

(Skip tests can be done with adding `-Dtest=false -DfailIfNoTests=false`)

This command assumes everything is running locally (like on the CDK). Otherwise, if deploying to a centralized openshift
  installation, you can build the docker image locally, then do `docker:push` to get the image up to OpenShift and then run the `fabric8:apply` command to deploy the app. 

## Install microservices

Make sure you've correctly setup the CDK env variables using the following command before running any `oc command`:

> eval "$(vagrant service-manager env docker)"

This command must be executed in the same directory as your VagrantFile.

Ensure you have logged into OpenShift via the command line (using admin/admin):

> oc login

From the `camel-router` directory of `camel-jms-eap-ose app` project, run:

> mvn clean install -Pfabric8 -Phawtapp -Pkube-generate docker:build fabric8:apply


