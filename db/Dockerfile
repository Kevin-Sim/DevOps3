# Use the latest MySQL image
#FROM mysql:latest
# or use the following image which solves issues on a Mac. Works on Windows also
FROM mysql/mysql-server:latest
COPY world.sql /docker-entrypoint-initdb.d
ENV MYSQL_ROOT_PASSWORD example
#Yet another Mac Fix
ENV MYSQL_ROOT_HOST=%