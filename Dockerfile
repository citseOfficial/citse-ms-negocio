FROM bellsoft/liberica-openjdk-alpine:latest
RUN apk add -U tzdata
ENV TZ America/Lima
RUN ln -snf /usr/share/zoneinfo/${TZ} /etc/localtime
RUN echo "${TZ}" > /etc/timezone
VOLUME /tmp
EXPOSE 8761
ADD ./target/citse-ms-negocio-0.0.1-SNAPSHOT.jar negocio.jar
ENTRYPOINT ["java", "-jar", "/negocio.jar"]