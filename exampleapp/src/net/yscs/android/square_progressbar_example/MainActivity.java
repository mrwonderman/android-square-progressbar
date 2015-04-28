package net.yscs.android.square_progressbar_example;

import java.util.ArrayList;

import net.yscs.android.square_progressbar.utils.ColourUtil;
import net.yscs.android.square_progressbar_example.dialogs.CustomColourDialog;
import net.yscs.android.square_progressbar_example.dialogs.PercentDialog;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private DrawerLayout drawerLayout;
	private ListView drawerListView;
	private ActionBarDrawerToggle drawerToggle;

	private CharSequence drawerTitle;
	private CharSequence title;
	public static String[] partTitle, descriptions;
	private SquareFragment squareFragment;

	private int lastPosition;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		FragmentManager fragmentManager = getFragmentManager();
		squareFragment = new SquareFragment();
		fragmentManager.beginTransaction()
				.replace(R.id.content_frame, squareFragment).commit();
		setContentView(R.layout.activity_main);

		title = drawerTitle = getTitle();
		partTitle = getResources().getStringArray(R.array.drawer_titel);
		descriptions = getResources().getStringArray(
				R.array.drawer_descriptions);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawerListView = (ListView) findViewById(R.id.left_drawer);

		drawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);
		BaseAdapter adapter = new BaseAdapter() {

			@Override
			public View getView(final int position, View convertView,
					ViewGroup parent) {
				View item = convertView;

				// Header Item
				View headerItem = LayoutInflater.from(getApplicationContext())
						.inflate(R.layout.lv_header_layout, parent, false);
				TextView title = (TextView) headerItem
						.findViewById(R.id.lv_list_hdr);

				// Custom Style Item
				View styleItem = LayoutInflater.from(getApplicationContext())
						.inflate(R.layout.lv_style, parent, false);
				CheckBox box = (CheckBox) styleItem
						.findViewById(R.id.checkBox1);

				// Custom Style Item
				View styleBoxItem = LayoutInflater
						.from(getApplicationContext()).inflate(
								R.layout.lv_style_box, parent, false);
				final CheckBox styleBox = (CheckBox) styleBoxItem
						.findViewById(R.id.checkBox11);
				ImageView styleImage = (ImageView) styleBoxItem
						.findViewById(R.id.imageView1);

				// Link to Github Item
				View githubItem = LayoutInflater.from(getApplicationContext())
						.inflate(R.layout.lv_github, parent, false);
				TextView githublink = (TextView) githubItem
						.findViewById(R.id.textView1);

				// Link to homepage Item
				View signerItem = LayoutInflater.from(getApplicationContext())
						.inflate(R.layout.lv_signer, parent, false);

				// Link to Image Item
				View imageItem = LayoutInflater.from(getApplicationContext())
						.inflate(R.layout.lv_image, parent, false);
				ImageView imagePreview = (ImageView) imageItem
						.findViewById(R.id.imageView1);
				TextView imageDesc = (TextView) imageItem
						.findViewById(R.id.imagetag);

				switch (position) {
				case 0:
					title.setText("Colour");
					return headerItem;
				case 11:
					Context context = getApplicationContext();
					item = LayoutInflater.from(context).inflate(
							R.layout.lv_colour_text, parent, false);
					item.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							final CustomColourDialog customColourDialog = new CustomColourDialog(
									MainActivity.this);
							customColourDialog.show();
							customColourDialog.getSaveButton()
									.setOnClickListener(new OnClickListener() {

										@Override
										public void onClick(View v) {
											squareFragment.squareProgressBar
													.setColorRGB(customColourDialog
															.getChoosenRGB());
											customColourDialog.dismiss();

										}
									});
							selectItem(position);
						}
					});
					TextView textView = (TextView) item
							.findViewById(R.id.colour_name_center);
					textView.setText("choose RGB colour");
					return item;
				case 12:
					title.setText("Style");
					return headerItem;

				case 13:
					box.setText(R.string.opacity);
					box.setChecked(squareFragment.squareProgressBar.isOpacity());
					box.setOnCheckedChangeListener(new OnCheckedChangeListener() {
						@Override
						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							squareFragment.squareProgressBar
									.setOpacity(isChecked);
						}
					});
					return styleItem;

				case 14:
					box.setText("Outline");
					box.setChecked(squareFragment.squareProgressBar.isOutline());
					box.setOnCheckedChangeListener(new OnCheckedChangeListener() {
						@Override
						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							squareFragment.squareProgressBar
									.drawOutline(isChecked);
						}
					});
					return styleItem;

				case 15:
					box.setText("Startline");
					box.setChecked(squareFragment.squareProgressBar
							.isStartline());
					box.setOnCheckedChangeListener(new OnCheckedChangeListener() {
						@Override
						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							squareFragment.squareProgressBar
									.drawStartline(isChecked);
						}
					});
					return styleItem;

				case 16:
					styleBox.setText("Show percent");
					styleBox.setChecked(squareFragment.squareProgressBar
							.isShowProgress());
					styleBox.setOnCheckedChangeListener(new OnCheckedChangeListener() {
						@Override
						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							squareFragment.squareProgressBar
									.showProgress(isChecked);
						}
					});
					styleImage.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							final PercentDialog percentDialog = new PercentDialog(
									MainActivity.this);
							percentDialog.show();
							percentDialog
									.setPercentStyle(squareFragment.squareProgressBar
											.getPercentStyle());
							percentDialog.getSaveButton().setOnClickListener(
									new OnClickListener() {

										@Override
										public void onClick(View v) {
											squareFragment.squareProgressBar
													.setPercentStyle(percentDialog
															.getSettings());
											percentDialog.dismiss();
											styleBox.setChecked(true);
											drawerLayout.closeDrawers();
										}
									});
						}
					});
					return styleBoxItem;

				case 17:
					box.setText("Grayscale");
					box.setChecked(squareFragment.squareProgressBar
							.isGreyscale());
					box.setOnCheckedChangeListener(new OnCheckedChangeListener() {
						@Override
						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							squareFragment.squareProgressBar
									.setImageGrayscale(isChecked);
						}
					});
					return styleItem;
				case 18:
					box.setText("Clear at 100%");
					box.setChecked(squareFragment.squareProgressBar
							.isClearOnHundred());
					box.setOnCheckedChangeListener(new OnCheckedChangeListener() {
						@Override
						public void onCheckedChanged(CompoundButton buttonView,
								boolean isChecked) {
							squareFragment.squareProgressBar
									.setClearOnHundred(isChecked);
						}
					});
					return styleItem;

				case 19:
					title.setText("Image");
					return headerItem;
				case 20:
					imagePreview.setImageResource(R.drawable.city);
					imageDesc.setText("sunrise at the city");
					imageItem.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							squareFragment.squareProgressBar
									.setImage(R.drawable.city);
						}
					});
					return imageItem;
				case 21:
					imagePreview
							.setImageResource(R.drawable.millennium_stadium);
					imageDesc.setText("the millennium stadium");
					imageItem.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							squareFragment.squareProgressBar
									.setImage(R.drawable.millennium_stadium);
						}
					});
					return imageItem;
				case 22:
					imagePreview.setImageResource(R.drawable.edinburgh);
					imageDesc.setText("carlton hill");
					imageItem.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							squareFragment.squareProgressBar
									.setImage(R.drawable.edinburgh);
						}
					});
					return imageItem;
				case 23:
					imagePreview.setImageResource(R.drawable.holyroodpark);
					imageDesc.setText("holyrood park");
					imageItem.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							squareFragment.squareProgressBar
									.setImage(R.drawable.holyroodpark);
						}
					});
					return imageItem;
				case 24:
					imagePreview.setImageResource(R.drawable.operahuset);
					imageDesc.setText("operahuset oslo");
					imageItem.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View v) {
							squareFragment.squareProgressBar
									.setImage(R.drawable.operahuset);
						}
					});
					return imageItem;
				case 25:
					title.setText("Source");
					return headerItem;
				case 26:
					String text = "<font color=#4183C4>mrwonderman</font>/<b><font color=#4183C4>android-square-progressbar</font></b>";
					githublink.setText(Html.fromHtml(text));
					githubItem.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							Intent browserIntent = new Intent(
									Intent.ACTION_VIEW,
									Uri.parse("https://github.com/mrwonderman/android-square-progressbar"));
							startActivity(browserIntent);
						}
					});
					return githubItem;
				case 27:
					signerItem.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							Intent browserIntent = new Intent(
									Intent.ACTION_VIEW, Uri
											.parse("http://www.signer.pro/"));
							startActivity(browserIntent);
						}
					});
					return signerItem;
				default:
					break;
				}

				ArrayList<Integer> colourArray = ColourUtil.getColourArray();

				if (position <= 10) {
					Context context = getApplicationContext();
					item = LayoutInflater.from(context).inflate(
							R.layout.lv_colour, parent, false);
					View colourView = item.findViewById(R.id.colour_preview);
					final Integer integer = colourArray.get(position - 1);
					colourView.setBackgroundColor(context.getResources()
							.getColor(integer));
					item.setOnClickListener(new OnClickListener() {

						@Override
						public void onClick(View arg0) {
							squareFragment.squareProgressBar
									.setHoloColor(integer);
							selectItem(position);
							lastPosition = position;
						}
					});
					TextView textView = (TextView) item
							.findViewById(R.id.colour_name);
					textView.setText(getName(position - 1));
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
				return 28;
			}
		};
		drawerListView.setAdapter(adapter);
		drawerListView.setOnItemClickListener(new DrawerItemClickListener());

		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			@Override
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(title);
				invalidateOptionsMenu();
			}

			@Override
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(drawerTitle);
				invalidateOptionsMenu();
			}
		};
		drawerLayout.setDrawerListener(drawerToggle);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		if (drawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return true;
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		return super.onPrepareOptionsMenu(menu);
	}

	@Override
	public void setTitle(CharSequence title) {
		this.title = title;
		getActionBar().setTitle(title);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		drawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		drawerToggle.onConfigurationChanged(newConfig);
	}

	private CharSequence getName(int position) {
		switch (position) {
		case 0:
			return "holo_blue_bright";
		case 1:
			return "holo_blue_dark";
		case 2:
			return "holo_blue_light";
		case 3:
			return "holo_green_dark";
		case 4:
			return "holo_green_light";
		case 5:
			return "holo_orange_dark";
		case 6:
			return "holo_orange_light";
		case 7:
			return "holo_purple";
		case 8:
			return "holo_red_dark";
		case 9:
			return "holo_red_light";

		default:
			break;
		}
		return "";
	}

	private void selectItem(int position) {
		drawerListView.setItemChecked(position, true);
	}

	private class DrawerItemClickListener implements
			ListView.OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			if ((position != 0) && (position != 11) && (position != 13)
					&& (position != 17)) {
				selectItem(position);
			} else {
				selectItem(lastPosition);
			}
		}
	}
}