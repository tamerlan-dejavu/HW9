package com.narxoz.rpg.vault;

import com.narxoz.rpg.artifact.Armor;
import com.narxoz.rpg.artifact.Inventory;
import com.narxoz.rpg.artifact.Potion;
import com.narxoz.rpg.artifact.Ring;
import com.narxoz.rpg.artifact.Scroll;
import com.narxoz.rpg.artifact.Weapon;
import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.combatant.HeroMemento;
import com.narxoz.rpg.memento.Caretaker;
import com.narxoz.rpg.visitor.CurseDetector;
import com.narxoz.rpg.visitor.EnchantmentScanner;
import com.narxoz.rpg.visitor.GoldAppraiser;
import com.narxoz.rpg.visitor.WeightCalculator;
import java.util.List;

public class ChronomancerEngine {

    public VaultRunResult runVault(List<Hero> party) {
        int mementosCreated = 0;
        int restoredCount = 0;

        Inventory vault = new Inventory();
        vault.addArtifact(new Weapon("Shadowblade", 120, 8, 15));
        vault.addArtifact(new Potion("Elixir of Might", 50, 1, 40));
        vault.addArtifact(new Scroll("Tome of Ruin", 80, 1, "Death Bolt"));
        vault.addArtifact(new Ring("Ring of Power", 200, 0, 20));
        vault.addArtifact(new Armor("Ironclad Plate", 150, 25, 30));
        vault.addArtifact(new Weapon("Cursed Dagger", 30, 3, -5));

        System.out.println("\n--- Vault Inventory: " + vault.size() + " artifacts ---");

        System.out.println("\n[Phase 1: Gold Appraisal]");
        GoldAppraiser appraiser = new GoldAppraiser();
        vault.accept(appraiser);
        System.out.println("Total vault value: " + appraiser.getTotalGold() + " gold");

        System.out.println("\n[Phase 2: Enchantment Scan]");
        vault.accept(new EnchantmentScanner());

        System.out.println("\n[Phase 3: Curse Detection]");
        CurseDetector detector = new CurseDetector();
        vault.accept(detector);
        System.out.println("Cursed items found: " + detector.getCursedCount());

        System.out.println("\n[Phase 4: Weight Calculation]");
        WeightCalculator wc = new WeightCalculator();
        vault.accept(wc);
        System.out.println("Total weight: " + wc.getTotalWeight() + " kg");

        Caretaker caretaker = new Caretaker();

        for (Hero hero : party) {
            System.out.println("\n--- " + hero.getName() + " enters the vault ---");
            System.out.println("Before trap : " + hero);

            HeroMemento snapshot = hero.createMemento();
            caretaker.save(snapshot);
            mementosCreated++;
            System.out.println("[Snapshot saved. Caretaker size: " + caretaker.size() + "]");

            hero.takeDamage(40);
            hero.spendMana(30);
            hero.spendGold(50);
            System.out.println("After trap  : " + hero);

            System.out.println("[Chronomancer rewinds time...]");
            hero.restoreFromMemento(caretaker.undo());
            restoredCount++;
            System.out.println("After rewind: " + hero);
        }

        return new VaultRunResult(vault.size(), mementosCreated, restoredCount);
    }
}
