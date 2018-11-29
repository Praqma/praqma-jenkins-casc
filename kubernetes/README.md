# Jenkins Configuration as Code in Kubernetes

For local development with Kubernetes in Docker for Windows

## Getting started

### Building the image

Build the image with

```shell
$ docker build -t figaw/jcasc:latest ./master       # replace figaw/jcasc with your-dockerhub-user/jcasc
...
```

> NB: on Windows: make sure that the `plugins_extra.txt` has `LF` line endings.
> see: [Docker Jenkins Image - curl: (3) Illegal characters found in URL](https://stackoverflow.com/a/35360709/1104755)

#### Push it to Dockerhub

It doesn't look like Kubernetes in Docker for Windows yet supports using your local docker registry,
    so `docker push your-dockerhub-user/jcasc` and
    replace the `image: figaw/jcasc` entry in the `30-jcasc-deployment.yaml`-file.

### Creating Namespace, PVC and Deployment

```shell
$ kubectl apply -Rf ./kubernetes
namespace "jcasc" created
persistentvolumeclaim "jenkins-pv-claim" created
deployment.apps "jenkins" created
service "jenkins" created
```

> NB: the jenkins pod won't start before the configmaps and secrets are created in the next step,
> but they need the namespace to be created, from the `kubernetes` folder.

### Creating the secrets and configmaps

Using the default `jenkins.yaml` in the root of this project:

```shell
# creating the jcasc-configmap
kubectl create configmap jcasc-configmap --from-file=./jenkins.yaml --namespace jcasc

# updating the configmap with a "dry-run pipe to stdin" trick
kubectl create configmap jcasc-configmap --from-file=./jenkins.yaml -o yaml --dry-run | kubectl replace -f -
```

You probably want to use Vault for passwords and such, but just to get started... generate an RSA key and put in the root of this project:

```shell
kubectl create secret generic github --from-literal=github_user=YOUR-GITHUB-USER --from-literal=github_pass=YOUR-GITHUB-PASS --namespace jcasc
kubectl create secret generic adminpw --from-literal=adminpw=password1 --namespace jcasc
kubectl create secret generic agent-private-key --from-file=./id_rsa --namespace jcasc
```

### Accessing Jenkins

Find the `NodePort` that your Jenkins deployment is exposed on with:

```shell
$ kubectl get svc -n jcasc
NAME      TYPE       CLUSTER-IP      EXTERNAL-IP   PORT(S)                        AGE
jenkins   NodePort   10.99.203.103   <none>        80:30584/TCP,50000:31975/TCP   2m
```

Access it in a browser on `localhost:<NodePort>` in my case `localhost:31975`

## FAQ

The naming of the files is simply classic database-config-ordering;
    I need the namespace to be created before any resources in it.
