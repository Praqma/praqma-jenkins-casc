FROM praqma/jenkins4casc:1.0-rc1

LABEL maintainer="man@praqma.net"
COPY plugins_extra.txt /usr/share/jenkins/ref/plugins_extra.txt

ARG JAVA_OPTS

RUN xargs /usr/local/bin/install-plugins.sh < /usr/share/jenkins/ref/plugins_extra.txt
