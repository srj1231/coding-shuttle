/**
 *
 # Homework
 1. list all annotations learnt so far.
 2. Scenarios where Spring Framework can be very useful over NodeJS.
 3. Scenarios where Spring Boot can be very useful over Spring Framework.
 4. Alice and her bakery:
 * CakeBaker class dependent on Frosting and Syrup classes. Has function bakeCake.
 * Interfaces Frosting and Syrup with functions getFrostingType and getSyrupType.
 * 2 implementations of these interfaces (so total 4 classes) for Strawberry and Chocolate flavours.
 * Use DI to inject the dependencies into CakeBaker and to call bakeCake method.
 */

package com.cs.saumya.week1HW;

import com.cs.saumya.week1HW.frosting.Frosting;
import com.cs.saumya.week1HW.frosting.StrawberryFrosting;
import com.cs.saumya.week1HW.syrup.StrawberrySyrup;
import com.cs.saumya.week1HW.syrup.Syrup;

public class Main {
    public static void main(String[] args) {
        Frosting strawberryFrosting = new StrawberryFrosting();
        Syrup strawberrySyrup = new StrawberrySyrup();
        CakeBaker cakeBaker = new CakeBaker(strawberryFrosting, strawberrySyrup);
        cakeBaker.bakeCake();
    }
}
