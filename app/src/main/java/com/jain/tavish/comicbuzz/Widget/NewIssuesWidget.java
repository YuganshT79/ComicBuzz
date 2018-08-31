package com.jain.tavish.comicbuzz.Widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.RemoteViews;

import com.jain.tavish.comicbuzz.R;
import com.jain.tavish.comicbuzz.UI.Activities.MainActivity;
import com.jain.tavish.comicbuzz.Utils.ConstantUtils;

/**
 * Implementation of App Widget functionality.
 */
public class NewIssuesWidget extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        CharSequence widgetText = context.getString(R.string.appwidget_text);
        // Construct the RemoteViews object
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_issues_widget);
        views.setTextViewText(R.id.tv_widget_issue_name, widgetText);

        // Instruct the widget manager to update the widget
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        // There may be multiple widgets active, so update all of them
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }

    @Override
    public void onEnabled(Context context) {
        // Enter relevant functionality for when the first widget is created
    }

    @Override
    public void onDisabled(Context context) {
        // Enter relevant functionality for when the last widget is disabled
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        super.onReceive(context, intent);

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.new_issues_widget);

        Intent widgetPressIntent = new Intent(context, MainActivity.class);
        PendingIntent buttonPressPendingIntent = PendingIntent.getActivity(context, 0, widgetPressIntent, 0);
        views.setOnClickPendingIntent(R.id.rl_widget_main_layout, buttonPressPendingIntent);

        SharedPreferences sharedPref = context.getSharedPreferences("Issues", Context.MODE_PRIVATE);

        String issueString = sharedPref.getString(ConstantUtils.SHARED_PREF_KEY_NAME, "");

        views.setTextViewText(R.id.tv_widget_issue_name, issueString);

        AppWidgetManager.getInstance(context).updateAppWidget(
                new ComponentName(context, NewIssuesWidget.class), views);
    }
}

