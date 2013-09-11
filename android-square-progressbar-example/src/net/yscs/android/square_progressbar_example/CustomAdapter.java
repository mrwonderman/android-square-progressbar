/*
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package net.yscs.android.square_progressbar_example;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    private static final int TYPE_HEADER = 0;
    private static final int TYPE_COLOR = 1;
    private static final int TYPE_IMAGE = 2;
    private static final int TYPE_AUTHOR = 3;
    private static final int TYPE_GITHUB = 4;
    private static final int TYPE_CLEAR_END = 5;
    private Context mContext;
    private LayoutInflater mInflater;
    private int[] mColors;
    private String[] mColorsNames;
    private int[] mImages;
    private String[] mImageDescriptions;
    private boolean mClearCheck = false;

    public CustomAdapter(Context context, int[] arrayColor,
            String[] arrayColorNames, int[] images, String[] imageDescription) {
        mContext = context;
        mInflater = LayoutInflater.from(mContext);
        mColors = arrayColor;
        mColorsNames = arrayColorNames;
        mImages = images;
        mImageDescriptions = imageDescription;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        View item = convertView;
        int type = getItemViewType(position);
        if (item == null) {
            switch (type) {
            case TYPE_HEADER:
                item = mInflater.inflate(R.layout.lv_header_layout, parent,
                        false);
                break;
            case TYPE_AUTHOR:
                item = mInflater.inflate(R.layout.lv_signer, parent, false);
                break;
            case TYPE_COLOR:
                item = mInflater.inflate(R.layout.lv_colour, parent, false);
                break;
            case TYPE_IMAGE:
                item = mInflater.inflate(R.layout.lv_image, parent, false);
                break;
            case TYPE_GITHUB:
                item = mInflater.inflate(R.layout.lv_github, parent, false);
                break;
            case TYPE_CLEAR_END:
                item = mInflater.inflate(R.layout.lv_clear, parent, false);
                break;
            }
        }
        switch (type) {
        case TYPE_HEADER:
            TextView title = (TextView) item.findViewById(R.id.lv_list_hdr);
            title.setText(position == 0 ? "Pick color"
                    : (position == 7 ? "Pick image:" : "Source links:"));
            break;
        case TYPE_AUTHOR:
            break;
        case TYPE_GITHUB:
            String text = "<font color=#4183C4>mrwonderman</font>/<b><font color=#4183C4>android-square-progressbar</font></b>";
            TextView link = (TextView) item.findViewById(R.id.textView1);
            link.setText(Html.fromHtml(text));
            break;
        case TYPE_COLOR:
            View preview = item.findViewById(R.id.colour_preview);
            TextView name = (TextView) item.findViewById(R.id.colour_name);
            preview.setBackgroundColor(mColors[position - 1]);
            name.setText(mColorsNames[position - 1]);
            break;
        case TYPE_IMAGE:
            ImageView img = (ImageView) item.findViewById(R.id.imageView1);
            TextView imageTag = (TextView) item.findViewById(R.id.imagetag);
            img.setImageResource(mImages[position - 8]);
            imageTag.setText(mImageDescriptions[position - 8]);
            break;
        case TYPE_CLEAR_END:
            CheckBox ckb = (CheckBox) item.findViewById(R.id.checkBox1);
            ckb.setText("Clear progress at end?");
            ckb.setChecked(mClearCheck);
            ckb.setOnCheckedChangeListener(new OnCheckedChangeListener() {

                @Override
                public void onCheckedChanged(CompoundButton buttonView,
                        boolean isChecked) {
                    mClearCheck = isChecked;
                    ((MainActivity) buttonView.getContext()).changeTarget(13,
                            isChecked);
                }
            });
            break;
        }
        return item;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return 1 + mColors.length + 1 + mImages.length + 3;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == 0 || position == 7 || position == 12 || position == 14) {
            return TYPE_HEADER;
        } else if (position >= 1 && position <= 6) {
            return TYPE_COLOR;
        } else if (position >= 8 && position <= 11) {
            return TYPE_IMAGE;
        } else if (position == 13) {
            return TYPE_CLEAR_END;
        } else if (position == 15) {
            return TYPE_AUTHOR;
        } else {
            return TYPE_GITHUB;
        }

    }

    @Override
    public int getViewTypeCount() {
        return 6;
    }

    @Override
    public boolean isEnabled(int position) {
        if (TYPE_HEADER == getItemViewType(position)) {
            return false;
        }
        return true;
    }

}
