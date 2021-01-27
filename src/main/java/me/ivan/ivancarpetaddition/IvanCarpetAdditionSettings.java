package me.ivan.ivancarpetaddition;

import carpet.settings.Rule;

import static carpet.settings.RuleCategory.*;

public class IvanCarpetAdditionSettings {
    public static final String ICA = "ICA";
    public static final String PROTOCOL = "protocol";

    @Rule(
            desc = "Set a custom version on client trying to connect to the server",
            extra = "use '_' to disable",
            options = "_",
            strict = false,
            category = {ICA, EXPERIMENTAL}
    )
    public static String customVersion = "_";

    @Rule(
            desc = "Sync entities and block entities between server and client",
            category = {ICA, PROTOCOL}
    )
    public static boolean icaSyncProtocol = false;

    @Rule(
            desc = "Override the slow down speed of cobwebs.",
            options = "0.05000000074505806",
            strict = false,
            category = {ICA, CREATIVE}
    )
    public static double cobwebSlowDown = 0.05000000074505806D;

    @Rule(
            desc = "Override the slow down speed of cobwebs.",
            options = {"bot_loader", "Steve,Alex", "Steve,Alex,bot_loader"},
            strict = false,
            category = {ICA, CREATIVE, SURVIVAL}
    )
    public static String fakePlayerPreset = "Steve,Alex";
}
