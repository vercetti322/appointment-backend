## Session Regestration Portal
This is a backend designed to handle form submission from the frontend (check code at [frontend](https://github.com/vercetti322/appointment-page.git/))
and authenticate user mobile number using OTP, after that a custom HTML mail is sent to user's inbox telling abt details of session
(like time & date). There is use of **JavaMailSender** class and **Twilio SMS API** for both the services (with good old spring-boot
an and in-memory relational DB H2).

### Configuration
Head on to [pom.xml](https://github.com/vercetti322/appointment-backend/blob/master/pom.xml/), to see the spring dependencies and
[Application.yml](https://github.com/vercetti322/appointment-backend/blob/master/src/main/resources/application.yml/) for configurations
relating to different spring components.

**Note**: Check out Twilio Java configuration at [Twilio Config](https://github.com/vercetti322/appointment-backend/blob/master/src/main/java/com/example/AppointmentBackend/sms/config/TwilioConfig.java/)
to better connect to Twilio client (the free plan has cap on set of numbers u can send SMS too via regestering it, find abt it more at [Twilio FAQ's](https://www.twilio.com/docs/messaging/guides/how-to-use-your-free-trial-account/))
Thus, this project can send the SMS to the mobile number I registered on my free tier account (which u can change when u register ur credentials).

## Building & Running
Just clone the project, configure the maven dependencies (pom.xml) and setup your Twilio API credentials as mentioned in the FAQ
link above and get going!

After above steps, u can be up & running on IDE like Intellij, simply hit run button on top pane (next to application name). Use the port 8090 as base and perform all
calls using Postman (or u can check out my frontend at the link mentioned above and use it to perform operations).

## Deployment
Now, u gotta generate a Dockerfile at the root of project (same level as src & target), and mention all ur details as below : 
```
FROM openjdk:22-jdk-slim (any version like 17 or 21 will do)

# Set the working directory inside the container
WORKDIR /app

# Copy the JAR file into the container
COPY target/AppointmentBackend-0.0.1-SNAPSHOT.jar /app/appointment.jar

# Expose the port your application will run on (same as the one u choose in application.yml)
EXPOSE 8090

LABEL authors="${username}" # not super-necessary

# Command to run the JAR file
ENTRYPOINT ["java", "-jar", "appointment.jar"]
```

Now, make sure u have docker installed, head over to [Docker Install](https://docs.docker.com/desktop/install/windows-install/)
in case u don't know how to setup (this is for windows, head over to linux one if u are on it)

Now, after this run following commands:
```
docker build -t appointment . # in your root dir, and "appointment" is just ur application name here.
docker run -p 8090:8090 appointment # (optional) to run the instance locally (debug if any issue happens here)
docker login # to log with ur creds
docker tage appointment ${docker_username}/appointment # to make a container instance on docker hub
docker push ${docker_username}/appointment # to push the code for making it available in hub
```

Now u got the docker image in ur hub, head on to [Render](https://render.com/) and follow all the steps to deploy, make sure to make a
free tier account and choose **Web Service** as type of deployment, link ur docker image and wait for ur application to go live!!

**NOTE**: there can be a downtime after a fixed time (cons of free tier) to ur service, so make sure when u load ur frontend page, u hit the
backend url also so that the service re-inits and u can make requests normally (it would take so much time otherwise).

CHEERS!!
