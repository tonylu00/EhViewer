/*
 * Copyright 2016 Hippo Seven
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.hippo.ehviewer.ui.fragment;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.preference.Preference;

import com.hippo.ehviewer.EhApplication;
import com.hippo.ehviewer.R;
import com.hippo.text.Html;
import com.hippo.util.AppHelper;

public class AboutFragment extends BasePreferenceFragment {

    private static final String KEY_AUTHOR = "author";
    //private static final String KEY_DONATE = "donate";
    private static final String KEY_CHECK_FOR_UPDATES = "check_for_updates";

    @Override
    public void onCreatePreferencesFix(@Nullable Bundle savedInstanceState, String rootKey) {
        addPreferencesFromResource(R.xml.about_settings);

        Preference author = findPreference(KEY_AUTHOR);
        //Preference donate = findPreference(KEY_DONATE);
        Preference checkForUpdate = findPreference(KEY_CHECK_FOR_UPDATES);

        if (author != null) {
            author.setOnPreferenceClickListener(this);
        }
        /*
        donate.setOnPreferenceClickListener(this);
        checkForUpdate.setOnPreferenceClickListener(this);
        checkForUpdate.setVisible(Analytics.isEnabled());
        */
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        String key = preference.getKey();
        if (KEY_AUTHOR.equals(key)) {
            AppHelper.sendEmail(requireActivity(), EhApplication.getDeveloperEmail(),
                    "About EhViewer", null);
        } else if (KEY_CHECK_FOR_UPDATES.equals(key)) {
            return true;
        }
        return true;
    }

    @Override
    public int getFragmentTitle() {
        return R.string.settings_about;
    }
}
