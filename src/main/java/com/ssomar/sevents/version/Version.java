package com.ssomar.sevents.version;

import org.bukkit.Bukkit;

public class Version {

    private static boolean is1v8 = false;
    private static boolean is1v9 = false;
    private static boolean is1v10 = false;
    private static boolean is1v11 = false;
    private static boolean is1v12 = false;
    private static boolean is1v13 = false;
    private static boolean is1v14 = false;
    private static boolean is1v15 = false;
    private static boolean is1v16 = false;
    private static boolean is1v16v1 = false;
    private static boolean is1v17 = false;
    private static boolean is1v18 = false;
    private static boolean is1v16Plus = false;
    private static boolean is1v17Plus = false;
    private static boolean is1v18Plus = false;

    public static void initVersion(){
        is1v8 = Bukkit.getServer().getVersion().contains("1.8");
        is1v9 = Bukkit.getServer().getVersion().contains("1.9");
        is1v10 = Bukkit.getServer().getVersion().contains("1.10");
        is1v11 = Bukkit.getServer().getVersion().contains("1.11");
        is1v12 = Bukkit.getServer().getVersion().contains("1.12");
        is1v13 = Bukkit.getServer().getVersion().contains("1.13");
        is1v14 = Bukkit.getServer().getVersion().contains("1.14");
        is1v15 = Bukkit.getServer().getVersion().contains("1.15");
        is1v16 = Bukkit.getServer().getVersion().contains("1.16");
        is1v16v1 = Bukkit.getServer().getVersion().contains("1.16.1");
        is1v17 = Bukkit.getServer().getVersion().contains("1.17");
        is1v18 = Bukkit.getServer().getVersion().contains("1.18");
    }


    /* The server is in 1.12 ? */
    public static boolean is1v8() {
        return is1v8;
    }

    /* The server is in 1.12 ? */
    public static boolean is1v9() {
        return is1v9;
    }

    /* The server is in 1.12 ? */
    public static boolean is1v10() {
        return is1v10;
    }

    /* The server is in 1.12 ? */
    public static boolean is1v11() {
        return is1v11;
    }

    /* The server is in 1.12 ? */
    public static boolean is1v12() {
        return is1v12;
    }

    /* The server is in 1.13 ? */
    public static boolean is1v13() {
        return is1v13;
    }

    /* The server is in 1.14 ? */
    public static boolean is1v14() {
        return is1v14;
    }

    /* The server is in 1.15 ? */
    public static boolean is1v15() {
        return is1v15;
    }

    /* The server is in 1.16 ? */
    public static boolean is1v16() {
        return is1v16;
    }

    /* The server is in 1.16 ? */
    public static boolean is1v16v1() {
        return is1v16v1;
    }

    /* The server is in 1.17 ? */
    public static boolean is1v17() {
        return is1v17;
    }

    /* The server is in 1.18 ? */
    public static boolean is1v18() {
        return is1v18;
    }

    /* The server is in 1.12 or - ? */
    public static boolean is1v11Less() {
        return is1v8() || is1v9() || is1v10() || is1v11() ;
    }

    /* The server is in 1.12 or - ? */
    public static boolean is1v12Less() {
        return is1v8() || is1v9() || is1v10() || is1v11() || is1v12() ;
    }

    /* The server is in 1.13 or - ? */
    public static boolean is1v13Less() {
        return is1v8() || is1v9() || is1v10() || is1v11() || is1v12() || is1v13();
    }

    /* The server is in 1.16 or + ? */
    public static boolean is1v16Plus() {
        return is1v16() || is1v17() || is1v18();
    }

    /* The server is in 1.17 or + ? */
    public static boolean is1v17Plus() {
        return is1v17() || is1v18();
    }

    /* The server is in 1.17 or + ? */
    public static boolean is1v18Plus() {
        return is1v18();
    }
}
