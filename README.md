# SpringBootDockerized

# Docker
- it is a platform for developers and sysadmin to develop, ship and run application by using container
- it help the user to quickly assemble application from its components and eliminate the friction during code shipping
- docker ais the user to test and deploy the code into production

# Container is running instance of image
- docker run --help it will show all commands
- docker rm container_id remove container
- You cannot remove runnig container 
- force rm docker rm -f (doesnt matter container is runnig or not)

# Docker functionalities
- develop app and its supporting components using containers
- test the application
- deploy the app into prod env as a container or an orchestrated service

# Docker object
1. container
2. images
3. network
4. volume


# Docker basic commands

> docker --version

> docker <docker-object> <sub-command> [options] <argument>

> docker image ls
> docker container ls
> docker network ls
> docker volume ls


# Container - create
> docker container create <image_name>
> docker container create httpd


# Container - List
> docker container ls		// list of all running container
> docker container ls -a	// list of all running and stopped container
> docker container ls -l	// get the last created container
> docker container ls -q	// get all running container ids
> docker container ls -aq	// get all running and stopped container ids
> docker ps


# Container - Start
> docker container create httpd
> docker container start <container_id>
> docker container start <container_name>
> docker container ls		or 		> docker ps


# Container - Run   (pull + create + start)
> docker container run -d httpd		// d - detach
> docker container run -d ubuntu


# every container is created to perform a task or opeartion and then after it completed the process it exit automatically, when we create a container using ubuntu it does not have any process or app it just use a base image to create other container. it is use to create a container based on ubuntu


> docker container run -it ubuntu (i - interactive, t - terminal)
> docker container run -itd ubuntu
> docker container run ubuntu -itd	// wrong command

# Port Mapping In Docker
> docker run --name website -d -p 8080:80 -p 5005:80 nginx:latest

# How to name container
> --name after run commands
> docker run --name website -d -p 8080:80 -p 5005:80 nginx:latest

# Container - Rename
> docker rename old_container_name  new_container_name


# Container - Stop / Pause
> docker container run --name web httpd
> docker container pause web
> docker container unpause web
> docker container stop web
> docker container kill --signal=9 web

> docker container stop <container_id>
> docker container stop <container_name>
> docker container stop $(docker container ls -q)
> docker container stop $(docker container ls -aq)


# Container - Remove  (we cannot remove runing container first stop container and then remove)
> docker container rm <container_id>
> docker container rm <container_name>
> docker container rm $(docker container ls -aq)
> docker container prune	// to delete all stopped containe


# Container - detach mode
by default container attach with the terminal
> docker container run http
> docker container attach <container_id>
> docker container attach <container_name>
> docker container run -d httpd


# Container - Interactive terminal
-it 	i - interactive		t - terminal
> docker container run -it ubuntu

[ctrl + p + q]



# Container - Exec
> docker container exec <container_id> hostname
> docker container exec -it <container_id> /bin/bash	 - give path of the shell
> docker container attach <container_id>


# Container - Inspect
> docker container inspect <container_id>
> docker container inspect <container_name>


# Container - logs
> docker container logs <container_id>
> docker container logs <container_name>
> docker container logs -f <container_name>




# How To Dockerize SpringBoot Appllication

> Step 1 : Create Dokcer File "Dockerfile"

> Step 2 : 	FROM openjdk:17
			ARG JAR_FILE=target/*.jar
			COPY ${JAR_FILE} app.jar
			ENTRYPOINT ["java", "-jar", "/app.jar"]
			EXPOSE 9000
			
			
> Step 3 : Build Docker Image --> docker build -t [IMAGE-NAME] .
			
> Step 4: create container    --> docker container run -d -p 9000:9000 --name spring-app spring-image

> Step 5: open in the browser --> http://localhost:9000








