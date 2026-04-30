package com.narxoz.rpg.visitor;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.ArtifactVisitor;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;

public class EnchantmentScanner implements ArtifactVisitor {

    @Override
    public void visit(Weapon w) {
        System.out.println("[EnchantmentScanner] " + w.getName() + ": attack enchantment +" + w.getAttackBonus());
    }

    @Override
    public void visit(Potion p) {
        System.out.println("[EnchantmentScanner] " + p.getName() + ": healing aura +" + p.getHealing() + " HP");
    }

    @Override
    public void visit(Scroll s) {
        System.out.println("[EnchantmentScanner] " + s.getName() + ": bound spell [" + s.getSpellName() + "]");
    }

    @Override
    public void visit(Ring r) {
        System.out.println("[EnchantmentScanner] " + r.getName() + ": magic resonance +" + r.getMagicBonus());
    }

    @Override
    public void visit(Armor a) {
        System.out.println("[EnchantmentScanner] " + a.getName() + ": ward enchantment +" + a.getDefenseBonus());
    }
}
