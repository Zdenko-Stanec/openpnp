package org.openpnp.machine.photon;

import org.openpnp.spi.Machine;

public class PhotonProperties {
    static final String FEEDER_COMMUNICATION_MAX_RETRY = "PhotonFeeder.FeederCommunicationMaxRetry";
    static final String FEEDER_SLOTS_PROPERTY = "PhotonFeeder.FeederSlots";
    static final String MAX_FEEDER_ADDRESS_PROPERTY = "PhotonFeeder.MaxFeederAddress";
    static final String FEED_STATUS_POLL_INTERVAL_PROPERTY = "PhotonFeeder.FeedStatusPollIntervalMilliseconds";
    static final String FEED_STATUS_POLL_TIMEOUT_PROPERTY = "PhotonFeeder.FeedStatusPollTimeoutMilliseconds";

    final Machine machine;

    public PhotonProperties(Machine machine) {
        this.machine = machine;
    }

    public int getFeederCommunicationMaxRetry() {
        Integer maxRetry = (Integer) machine.getProperty(FEEDER_COMMUNICATION_MAX_RETRY);

        if(maxRetry == null) {
            maxRetry = 3;
            setFeederCommunicationMaxRetry(maxRetry);
        }

        return maxRetry;
    }

    public void setFeederCommunicationMaxRetry(int maxRetry) {
        machine.setProperty(FEEDER_COMMUNICATION_MAX_RETRY, maxRetry);
    }

    public int getMaxFeederAddress() {
    	Integer maxFeederAddress = (Integer) machine.getProperty(MAX_FEEDER_ADDRESS_PROPERTY);

        if(maxFeederAddress == null) {
            maxFeederAddress = 50;
            setMaxFeederAddress(maxFeederAddress);
        }

        return maxFeederAddress;
    }

    public void setMaxFeederAddress(int maxFeederAddress) {
    	 machine.setProperty(MAX_FEEDER_ADDRESS_PROPERTY, maxFeederAddress);
    }

    public int getFeedStatusPollInterval() {
        Integer feedStatusPollInterval = (Integer) machine.getProperty(FEED_STATUS_POLL_INTERVAL_PROPERTY);

        if(feedStatusPollInterval == null) {
            feedStatusPollInterval = 100;
            setFeedStatusPollInterval(feedStatusPollInterval);
        }

        return feedStatusPollInterval;
    }

    public void setFeedStatusPollInterval(int feedStatusPollInterval) {
        machine.setProperty(FEED_STATUS_POLL_INTERVAL_PROPERTY, feedStatusPollInterval);
    }

    public int getFeedStatusPollTimeout() {
        Integer feedStatusPollTimeout = (Integer) machine.getProperty(FEED_STATUS_POLL_TIMEOUT_PROPERTY);

        if(feedStatusPollTimeout == null) {
            feedStatusPollTimeout = 10000;
            setFeedStatusPollTimeout(feedStatusPollTimeout);
        }

        return feedStatusPollTimeout;
    }

    public void setFeedStatusPollTimeout(int feedStatusPollTimeout) {
        machine.setProperty(FEED_STATUS_POLL_TIMEOUT_PROPERTY, feedStatusPollTimeout);  
    	
    }

    public synchronized PhotonFeederSlots getFeederSlots() {
        PhotonFeederSlots feederSlots = (PhotonFeederSlots) machine.getProperty(FEEDER_SLOTS_PROPERTY);

        if(feederSlots == null) {
            feederSlots = new PhotonFeederSlots();
            machine.setProperty(FEEDER_SLOTS_PROPERTY, feederSlots);
        }

        return feederSlots;
    }
}
