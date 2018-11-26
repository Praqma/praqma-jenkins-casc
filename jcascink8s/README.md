# Helm chart for JCasCinK8S

Jenkins Configuration as Code in Kubernetes

## WIP

- `NOTES.txt` should be updated so it's relevant to the deployment.
- `values.yaml` still contains boilerplate Helm values and references image `figaw/jcasc`.
    The docker compose example builds the image on deployment; kubernetes needs the image to
    be already built.
- the templates aren't at all properly namespaced or annotated.
