package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.ArtifactVisitor;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;

public class WeightCalculator implements ArtifactVisitor {

    private int totalWeight;

    public int getTotalWeight() { return totalWeight; }

    @Override
    public void visit(Weapon w) {
        totalWeight += w.getWeight();
        System.out.println("[WeightCalculator] " + w.getName() + ": " + w.getWeight() + " kg");
    }

    @Override
    public void visit(Potion p) {
        totalWeight += p.getWeight();
        System.out.println("[WeightCalculator] " + p.getName() + ": " + p.getWeight() + " kg");
    }

    @Override
    public void visit(Scroll s) {
        totalWeight += s.getWeight();
        System.out.println("[WeightCalculator] " + s.getName() + ": " + s.getWeight() + " kg");
    }

    @Override
    public void visit(Ring r) {
        totalWeight += r.getWeight();
        System.out.println("[WeightCalculator] " + r.getName() + ": " + r.getWeight() + " kg");
    }

    @Override
    public void visit(Armor a) {
        totalWeight += a.getWeight();
        System.out.println("[WeightCalculator] " + a.getName() + ": " + a.getWeight() + " kg");
    }
}
