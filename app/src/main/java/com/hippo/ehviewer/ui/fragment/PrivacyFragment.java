package com.hippo.ehviewer.ui.fragment;

import android.os.Bundle;
import android.text.TextUtils;

import androidx.annotation.Nullable;
import androidx.preference.Preference;

import com.hippo.ehviewer.R;
import com.hippo.ehviewer.Settings;

/**
 * Created by Mo10 on 2018/2/10.
 */

public class PrivacyFragment extends BasePreferenceFragment {
    private static final String KEY_PATTERN_PROTECTION = "pattern_protection";

    @Override
    public void onCreatePreferencesFix(@Nullable Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.privacy_settings);
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public boolean onPreferenceChange(Preference preference, Object newValue) {
        String key = preference.getKey();
        return true;
    }

    @Override
    public int getFragmentTitle() {
        return R.string.settings_privacy;
    }
}
