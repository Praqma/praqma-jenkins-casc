# praqma-jenkins-casc
Repository for our JCasC demo setup.

## Requirements

First off we require docker-compose. Tested with `docker-compose version 1.20.1`. 

The demo cofiguration we've prepared is not using any secrets. Default user we create has secrets in configuration section in casc_configs/jenkins.yaml (lines 16 and 17) but since we do not expect you to do ANYTHING other than running docker-compose to get Jenkins up, the secret related sections in docker-compose.yml are commented and we'll use default hardcoded values for demo purpose.

If you're familiar with docker secrets you can provide actual secrets - remember to update docker-compose.yml

## First boot 

This is very simple, using docker-compose execute the following command from the root of this repository:

`docker-compose up --build`

This will start up a Jenkins instance which will be accessible on the host through port 80, just open your browser and navigate to http://localhost

What you might want to change though is the configuration file used by the Configuration as Code plugin. Currently `CASC_JENKINS_CONFIG` points to `casc_configs` folder with initial, basic configuration files. You're good to go with those but feel free to change the configuration and see how it works.

Any time you change you're configuration files on host machine you need to reload it in Jenkins:

Manage Jenkins -> Configuration as Code -> Reload existing configuration
