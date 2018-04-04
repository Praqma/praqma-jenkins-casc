FROM praqma/jenkins4casc:0.2-alpha-latest 

LABEL maintainer="man@praqma.net" 
COPY plugins_extra.txt /usr/share/jenkins/ref/plugins_extra.txt

ARG JAVA_OPTS
ENV JAVA_OPTS "-Djenkins.CLI.disabled=true ${JAVA_OPTS:-}"

RUN xargs /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins_extra.txt