package main;

import controller.DomainController;
import cui.ZatreApplicatie;

public class StartupCui {
    public static void main(String[] args) {
        ZatreApplicatie zatreApplicatie = new ZatreApplicatie(new DomainController());

        zatreApplicatie.start();
    }
}
