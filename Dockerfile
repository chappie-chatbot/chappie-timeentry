FROM maven:3-jdk-8

ENV HOMEDIR /chappie

WORKDIR $HOMEDIR

ADD ./entrypoint.sh /

RUN useradd -d $HOMEDIR chappie

RUN mkdir -p $HOMEDIR && chown -R chappie $HOMEDIR

USER chappie

RUN git clone https://github.com/chappie-chatbot/chappie-timeentry.git chappie-timeentry

ENTRYPOINT ["/entrypoint.sh"]

