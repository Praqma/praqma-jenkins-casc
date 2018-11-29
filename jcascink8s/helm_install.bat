kubectl create -f helm_sa.yml
helm init --service-account tiller

echo "Now wait for tiller to start by running
kubectl get pods --all-namespaces
"
