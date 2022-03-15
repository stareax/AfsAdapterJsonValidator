package com.example.afsadapterjsonvalidator;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Archive;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import javax.inject.Inject;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Arquillian.class)
class AfsAdapterControllerTest {
    @Deployment
    public static Archive<?> createDeployment() {
        return ShrinkWrap.create(WebArchive.class)
                .addClass(AfsAdapterController.class)
                .addAsResource("META-INF/microprofile-config.properties")
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    @Inject
    AfsAdapterController afsAdapterController;

    @Test
    void request() {
        afsAdapterController.request();
    }
}