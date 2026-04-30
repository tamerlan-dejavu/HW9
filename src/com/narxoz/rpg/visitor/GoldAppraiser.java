package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.ArtifactVisitor;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;

public class GoldAppraiser implements ArtifactVisitor {

    private int totalGold;

    public int getTotalGold() { return totalGold; }

    @Override
    public void visit(Weapon w) {
        int price = w.getValue() + w.getAttackBonus() * 10;
        totalGold += price;
        System.out.println("[GoldAppraiser] " + w.getName() + " -> " + price + " gold");
    }

    @Override
    public void visit(Potion p) {
        int price = p.getValue() + p.getHealing() * 2;
        totalGold += price;
        System.out.println("[GoldAppraiser] " + p.getName() + " -> " + price + " gold");
    }

    @Override
    public void visit(Scroll s) {
        int price = s.getValue() * 2;
        totalGold += price;
        System.out.println("[GoldAppraiser] " + s.getName() + " (" + s.getSpellName() + ") -> " + price + " gold");
    }

    @Override
    public void visit(Ring r) {
        int price = r.getValue() + r.getMagicBonus() * 15;
        totalGold += price;
        System.out.println("[GoldAppraiser] " + r.getName() + " -> " + price + " gold");
    }

    @Override
    public void visit(Armor a) {
        int price = a.getValue() + a.getDefenseBonus() * 8;
        totalGold += price;
        System.out.println("[GoldAppraiser] " + a.getName() + " -> " + price + " gold");
    }
}
