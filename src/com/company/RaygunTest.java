package com.company;

import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RaygunTest {

    @Test
    public void testFireAtGunIsNotCharged() {
        // Arrange
        Raygun gun = new Raygun(5, 0);
        Alien bug = new Alien(false, 10);
        int expectedAlienHealth = 10;
        int expectedCharge = 0;

        // Act
        gun.fireAt(bug);
        int actualCharge = gun.getcChrg();
        int actualHealth = bug.getAlienHealth();

        // Assert
        assertEquals(expectedCharge, actualCharge, "charge should not change if gun did not fire");
        assertEquals(expectedAlienHealth, actualHealth, "should not change alien health if gun does not fire");
    }

    @Test
    public void testFireAt_ReducesChargeByOne() {
        // Arrange
        int startingCharge = 3;
        Raygun gun = new Raygun(5, startingCharge);
        Alien bug = new Alien(false, 10);
        int expectedCharge = startingCharge--;

        // Act
        gun.fireAt(bug);
        int actualCharge = gun.getcChrg();

        // Assert
        assertEquals(expectedCharge, actualCharge, "charge should change if gun fired");
    }

    @Test
    public void testFireAt_dodgingBugShouldNotReceiveHit() {
        Raygun gun = new Raygun(5, 3);
        Alien bug = new Alien(true, 10);
        int expectedAlienHealth = 10;

        // Act
        gun.fireAt(bug);
        int actualHealth = bug.getAlienHealth();

        // Assert
        assertEquals(expectedAlienHealth, actualHealth, "should not change alien health if alien dodges");
    }

    @Test
    public void testFireAt() {
        // Arrange
        int startingAlienHealth = 10;
        Raygun gun = new Raygun(5, 3);
        Alien bug = new Alien(false, startingAlienHealth);
        int expectedAlienHealth = startingAlienHealth--;

        // Act
        gun.fireAt(bug);
        int actualHealth = bug.getAlienHealth();

        // Assert
        assertEquals(expectedAlienHealth, actualHealth, "should change alien health if gun fires and alien gets hit");
    }

    @Test
    public void testRecharge_AtRegularChargeLevel() {
        // Arrange
        int currentCharge = 1;
        int expectedCharge = currentCharge++;
        Raygun gun = new Raygun(3, currentCharge);

        // Act
        gun.recharge();
        int actualCharge = gun.getcChrg();

        // Assert
        Assert.assertEquals(expectedCharge, actualCharge, "should increase the charge if recharge");
    }

    @Test
    public void testRecharge_AtMaximumChargeLevel() {
        // Arrange
        int currentCharge = 3;
        int maxCharge = currentCharge;
        Raygun gun = new Raygun(maxCharge, currentCharge);

        // Act
        gun.recharge();
        int actualCharge = gun.getcChrg();

        // Assert
        Assert.assertEquals(currentCharge, actualCharge, "should keep the same charge if recharge at maximum charge");
    }

    @Test
    public void testIsCharged_GunHasAtLeastOneCharge() {
        // Arrange
        Raygun gun = new Raygun(5, 1);
        boolean expectedValue = true;

        // Act
        boolean actualValue = gun.isCharged();

        // Assert
        assertEquals(expectedValue,actualValue,"should return true if gun has a charge");
    }

    @Test
    public void testIsCharged_GunHasNoCharge() {
        // Arrange
        Raygun gun = new Raygun(5, 0);
        boolean expectedValue = false;

        // Act
        boolean actualValue = gun.isCharged();

        // Assert
        assertEquals(expectedValue,actualValue,"should return false if gun has no charge");
    }

    @Test
    public void testIsFullyCharged_GunAtMaximumCharge() {
        // Arrange
        int charge = 5;
        boolean expectedValue = true;
        Raygun gun = new Raygun(charge, charge);

        // Act
        boolean actualValue = gun.isFullyCharged();

        // Assert
        assertEquals(expectedValue,actualValue,"should return true if gun has same charge as max charge");
    }

    @Test
    public void testIsFullyCharged_GunAtAnyChargeLevelNotMax() {
        // Arrange
        int charge = 5;
        int mCharge = 10;
        Raygun gun = new Raygun(mCharge, charge);
        boolean expectedValue = false;

        // Act
        boolean actualValue = gun.isFullyCharged();

        // Assert
        assertEquals(expectedValue,actualValue,"should return false if gun does not have same charge as max charge");
    }
}