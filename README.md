# praqma-jenkins-casc
Repository for our casc demo setup 

## Requirements

First off we require docker-compose. Tested with `docker-compose version 1.20.1`. 

The demo we've prepared here also expects two secrets (files) to be present:

1. `/var/deploy/secrets/github` 
2. `/var/deploy/secrets/adminpw`

The first one is a secret for your github user account (One with write access) to github repositories. For this demo we've used our own user `ReleasePraqma` and provided the appropriate password. The second password is for the one Admin user we add to our server with the id `demoAdmin`. 

## First boot 

This is very simple, using docker-compose execute the following command from the root of this repository:

`docker-compose up --build`

This will start up a Jenkins instance which will be accessible on the host through port 80.

What you might want to change though is the configuration file used by the Configuration as Code plugin. Currently it points to our own `jenkins.yaml` file hosted on GitHub. 

Change this to a more approriate link that contains your own setup. 

```
    environment:
      - CASC_JENKINS_CONFIG=https://raw.githubusercontent.com/Praqma/praqma-jenkins-casc/master/jenkins.yaml
```
That should be it. Once you've pointed to your own config file you're done!

## Alternative configuration source

If you don't have anywhere to host your configuration file, you can mount your configuration file into the service using docker compose and point to the file using a local path instead. Like so:
```
    environment:
      - CASC_JENKINS_CONFIG=/path/to/my/jenkins.yaml
```