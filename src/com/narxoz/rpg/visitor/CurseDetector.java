package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.ArtifactVisitor;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;

public class CurseDetector implements ArtifactVisitor {

    private int cursedCount;

    public int getCursedCount() { return cursedCount; }

    @Override
    public void visit(Weapon w) {
        if (w.getAttackBonus() < 0) {
            cursedCount++;
            System.out.println("[CurseDetector] WARNING: " + w.getName() + " is cursed (penalty: " + w.getAttackBonus() + ")");
        } else {
            System.out.println("[CurseDetector] " + w.getName() + ": clean");
        }
    }

    @Override
    public void visit(Potion p) {
        if (p.getHealing() < 0) {
            cursedCount++;
            System.out.println("[CurseDetector] WARNING: " + p.getName() + " is poisoned (effect: " + p.getHealing() + ")");
        } else {
            System.out.println("[CurseDetector] " + p.getName() + ": safe");
        }
    }

    @Override
    public void visit(Scroll s) {
        String spell = s.getSpellName().toLowerCase();
        boolean dark = spell.contains("dark") || spell.contains("death") || spell.contains("doom");
        if (dark) {
            cursedCount++;
            System.out.println("[CurseDetector] WARNING: " + s.getName() + " holds dark magic [" + s.getSpellName() + "]");
        } else {
            System.out.println("[CurseDetector] " + s.getName() + ": benign spell");
        }
    }

    @Override
    public void visit(Ring r) {
        if (r.getMagicBonus() < 0) {
            cursedCount++;
            System.out.println("[CurseDetector] WARNING: " + r.getName() + " drains magic (penalty: " + r.getMagicBonus() + ")");
        } else {
            System.out.println("[CurseDetector] " + r.getName() + ": clean");
        }
    }

    @Override
    public void visit(Armor a) {
        if (a.getDefenseBonus() < 0) {
            cursedCount++;
            System.out.println("[CurseDetector] WARNING: " + a.getName() + " weakens defense (penalty: " + a.getDefenseBonus() + ")");
        } else {
            System.out.println("[CurseDetector] " + a.getName() + ": clean");
        }
    }
}
