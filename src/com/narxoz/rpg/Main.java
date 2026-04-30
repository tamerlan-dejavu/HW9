package com.narxoz.rpg;

import com.narxoz.rpg.combatant.Hero;
import com.narxoz.rpg.vault.ChronomancerEngine;
import com.narxoz.rpg.vault.VaultRunResult;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        System.out.println("=== Homework 9 Demo: Visitor + Memento ===");

        Hero warrior = new Hero("Aldric the Warrior", 120, 20, 25, 15, 100, null);
        Hero mage    = new Hero("Seraphina the Mage",  70, 80, 10,  5, 200, null);

        ChronomancerEngine engine = new ChronomancerEngine();
        VaultRunResult result = engine.runVault(List.of(warrior, mage));

        System.out.println("\n=== Vault Run Complete ===");
        System.out.println(result);
    }
}
