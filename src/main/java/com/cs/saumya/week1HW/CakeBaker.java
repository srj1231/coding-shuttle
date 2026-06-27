package com.cs.saumya.week1HW;

import com.cs.saumya.week1HW.frosting.Frosting;
import com.cs.saumya.week1HW.syrup.Syrup;

public class CakeBaker {
    private final Frosting frosting;
    private final Syrup syrup;

    public CakeBaker(Frosting frosting, Syrup syrup) {
        this.frosting = frosting;
        this.syrup = syrup;
    }

    public void bakeCake() {
        System.out.println("Baking cake with "
                + frosting.getFrostingType()
                + " frosting and "
                + syrup.getSyrupType()
                + " syrup."
        );
    }
}
