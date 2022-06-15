# Image to start project and initialize dependencies.
FROM openjdk:8 AS initializer
ENV GRAILS_VERSION 5.1.8
# Install Grails
WORKDIR /usr/lib/jvm
RUN ls -l
RUN wget https://github.com/grails/grails-core/releases/download/v$GRAILS_VERSION/grails-$GRAILS_VERSION.zip && \
    unzip grails-$GRAILS_VERSION.zip && \
    rm -rf grails-$GRAILS_VERSION.zip && \
    ln -s grails-$GRAILS_VERSION grails
# Setup Grails path.
ENV GRAILS_HOME /usr/lib/jvm/grails
ENV PATH $GRAILS_HOME/bin:$PATH
ENV GRADLE_USER_HOME /app/.gradle
# Create minimal structure to trigger grails build with specified profile.
RUN mkdir /incomeOutcomeApp \
    && mkdir /incomeOutcomeApp/grails-app \
    && mkdir /incomeOutcomeApp/grails-app/conf \
    && echo "grails.profile: web" > /incomeOutcomeApp/grails-app/conf/application.yml
# Set Workdir
WORKDIR /incomeOutcomeApp
# Copy minimun files to trigger grails download of wrapper and dependencies.
COPY gradle.properties build.gradle /incomeOutcomeApp/
# Trigger gradle build
RUN [ "grails", "stats" ]

COPY grails-app /incomeOutcomeApp/grails-app
COPY src /incomeOutcomeApp/src

RUN ["grails", "prod", "war"]

FROM openjdk:8-jdk AS production
COPY --from=initializer /incomeOutcomeApp/build/libs/*-0.1.war /incomeOutcomeApp.war

EXPOSE 8080
CMD ["java", "-jar", "incomeOutcomeApp.war"]