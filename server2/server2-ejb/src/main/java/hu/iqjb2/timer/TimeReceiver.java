/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.iqjb2.timer;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author IQJB
 */
@MessageDriven(mappedName = "jms/iqjb-queue", activationConfig = {
    @ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
})
public class TimeReceiver implements MessageListener {

    private static final Logger LOG = Logger.getLogger(TimeReceiver.class.getName());

    public TimeReceiver() {
    }

    @Override
    public void onMessage(Message message) {
        try {
            TextMessage msg = (TextMessage) message;
            LOG.log(Level.INFO, "Receving: {0}", msg.getText());
        } catch (JMSException e) {
            System.out.println("Error during processing message " + e);
        }
    }

}
