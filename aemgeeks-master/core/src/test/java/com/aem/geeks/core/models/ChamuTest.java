package com.aem.geeks.core.models;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.apache.sling.api.resource.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ChamuTest {

    private static final String DEFAULT_MY = "chamu Reddy";
    private static final String DEFAULT_YOUTUBE = "chamu Reddy, naid";
    private static final String PHONE = "1234567890";
    private static final String DATE = "2024-01-01";
    private static final String PEN = "Ballpoint";
    private static final String RED = "Red Pen";

    @Mock
    private Resource resource;

    @InjectMocks
    private Chamu chamu;

    @BeforeEach
    public void setup() {
        // Mock the resource to return the injected values
        when(resource.getValueMap().get("my", String.class)).thenReturn(DEFAULT_MY);
        when(resource.getValueMap().get("phone", String.class)).thenReturn(PHONE);
        when(resource.getValueMap().get("date", String.class)).thenReturn(DATE);
        when(resource.getValueMap().get("youtube", String.class)).thenReturn(DEFAULT_YOUTUBE);
        when(resource.getValueMap().get("pen", String.class)).thenReturn(PEN);
        when(resource.getValueMap().get("red", String.class)).thenReturn(RED);

        // Adapt the resource to the Chamu model
        chamu = resource.adaptTo(Chamu.class);
    }

    @Test
    public void testGetMy() {
        assertEquals(DEFAULT_MY, chamu.getMy());
    }

    @Test
    public void testGetPhone() {
        assertEquals(PHONE, chamu.getPhone());
    }

    @Test
    public void testGetDate() {
        assertEquals(DATE, chamu.getDate());
    }

    @Test
    public void testGetYoutube() {
        assertEquals(DEFAULT_YOUTUBE, chamu.getYoutube());
    }

    @Test
    public void testGetPen() {
        assertEquals(PEN, chamu.getPen());
    }

    @Test
    public void testGetRed() {
        assertEquals(RED, chamu.getRed());
    }
}
