FROM ubuntu:latest
LABEL authors="yash"

ENTRYPOINT ["top", "-b"]