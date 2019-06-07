/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.iqjb2.timer;

import java.util.Date;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Schedule;
import javax.ejb.Singleton;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author IQJB
 */
@Singleton
@LocalBean
public class TimeProducer {

    private static final Logger LOG = Logger.getLogger(TimeProducer.class.getName());

    @Resource(mappedName = "jms/iqjb-queue")
    private Destination queue;

    @Resource(mappedName = "jms/iqjb-factory")
    private ConnectionFactory queueFactory;

    @Schedule(second = "0/5", minute = "*", hour = "*")
    public void sendMessage() {
        LOG.info("Message is senindg.."); //TODO not working
        sendJMSMessage(new Date().toString());
    }

    private TextMessage createJMSMessage(Session session, String messageData) throws JMSException {
        TextMessage tm = session.createTextMessage();
        tm.setText(messageData);
        LOG.info(messageData);
        return tm;
    }

    private void sendJMSMessage(String messageData) {
        Connection connection = null;
        Session session = null;
        try {
            connection = queueFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer = session.createProducer(queue);
            Message msg = createJMSMessage(session, messageData);
            messageProducer.send(msg);
        } catch (JMSException e) {
            System.err.println("Error sending message:" + e);
        } finally {
            if (session != null) {
                try {
                    session.close();
                } catch (JMSException e2) {
                    System.err.println("Error closing session:" + e2);
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (JMSException e2) {
                    System.err.println("Error closing connection:" + e2);
                }
            }
        }
    }
}
