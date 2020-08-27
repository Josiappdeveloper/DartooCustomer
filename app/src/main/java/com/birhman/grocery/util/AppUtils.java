package com.birhman.grocery.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

import com.birhman.grocery.BuildConfig;

public class AppUtils {
    public static void shareApp(Context context) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT,
                "Hey check out app at: https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID);
        sendIntent.setType("text/plain");
        context.startActivity(sendIntent);
    }

    public static void rateApp(Context context) {
        Intent sendIntent;
        final String appPackageName = context.getPackageName(); // getPackageName() from Context or Activity object
        try {
            sendIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=" + appPackageName));
        } catch (android.content.ActivityNotFoundException anfe) {
            sendIntent = new Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName));
        }
        context.startActivity(sendIntent);
    }
}
