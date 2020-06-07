package islamic.ebadaty;

import android.app.ListActivity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class WorshipReward extends ListActivity {
	ListView myList;
	Intent intent;
@Override
protected void onCreate(Bundle savedInstanceState) {
	// TODO Auto-generated method stub
	super.onCreate(savedInstanceState);
	getWindow().setBackgroundDrawableResource(R.drawable.bg_main_simple); 
    getListView().setBackgroundColor(Color.TRANSPARENT); 
    getListView().setCacheColorHint(Color.TRANSPARENT); 

	setListAdapter(new WorshipRewardAdapter(this,
			android.R.layout.simple_list_item_1,
			R.id.tv_leftToRight,
			getResources().getStringArray(R.array.report_names)));
}

private class WorshipRewardAdapter extends ArrayAdapter<String>{

	public WorshipRewardAdapter(Context context, int resource,
			int textViewResourceId, String[] objects) {
		super(context, resource, textViewResourceId, objects);
		// TODO Auto-generated constructor stub
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO Auto-generated method stub
		LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View row = inflater.inflate(R.layout.arabic_list, parent, false);
		String []ReportItems = getResources().getStringArray(R.array.report_names);
		
		TextView separator = (TextView) row.findViewById(R.id.tv_arabicSeparator);
		TextView report_tv = (TextView) row.findViewById(R.id.tv_leftToRight);
		report_tv.setText(ReportItems[position]);
		ImageView report_image = (ImageView) row.findViewById(R.id.iv_fada2el_reportImage);
		switch (position) {
		case 0:
			report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_salah));
			separator.setVisibility(View.VISIBLE);
			separator.setText(R.string.category_salah);
			report_tv.setText(R.string.row1_salah_gama3a);

			break;
		case 1:
			report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_salah));
			report_tv.setText(R.string.row2_salah_sunna);
			break;
		case 2:
			report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_salah));
			report_tv.setText(R.string.row3_salah_qeyam);
			break;
		case 3:
			report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_salah));
			report_tv.setText(R.string.row4_salah_wetr);
			break;
		case 4:
			report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_salah));
			report_tv.setText(R.string.row5_salah_doha);
			break;
		case 5:
			report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_quran));
			separator.setVisibility(View.VISIBLE);
			separator.setText(R.string.category_quran);
			report_tv.setText(R.string.row6_quran_qera2a);
			break;
		case 6:
			report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_quran));
			report_tv.setText(R.string.row7_quran_7efz);
			break;
		case 7:
			report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_zekr));
			separator.setVisibility(View.VISIBLE);
			separator.setText(R.string.category_zekr);
			report_tv.setText(R.string.row8_zekr_saba7_masa2);
			break;
		case 8:
			report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_zekr));
			report_tv.setText(R.string.row9_zekr_estykaz_nom);
			break;
		case 9:
			report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_zekr));
			report_tv.setText(R.string.row10_zekr_afterSalah);
			break;
		case 10:
			report_image.setImageDrawable(getResources().getDrawable(R.drawable.lv_sawm));
			separator.setVisibility(View.VISIBLE);
			separator.setText(R.string.category_sawm);
			report_tv.setText(R.string.row11_sawm);
			break;
		default:
			break;
		}
		/*switch (position) {
		case 0:
			separator.setVisibility(View.VISIBLE);
			separator.setText(R.string.category_salah);
			break;
		case 5:
			separator.setVisibility(View.VISIBLE);
			separator.setText(R.string.category_quran);
			break;
		case 7:
			separator.setVisibility(View.VISIBLE);
			separator.setText(R.string.category_zekr);
			break;
		case 10:
			separator.setVisibility(View.VISIBLE);
			separator.setText(R.string.category_sawm);
			break;
		default:
			break;
		}*/
		return row;
	}

}
		@Override
		protected void onListItemClick(ListView l, View v, int position, long id) {
			// TODO Auto-generated method stub
			super.onListItemClick(l, v, position, id);
			switch (position) {
			case 0:
				intent = new Intent(this, WorshipRewardOnly.class);
				intent.putExtra("TITLE", R.string.row1_salah_gama3a);
				intent.putExtra("DESC", R.raw.salah_gamaa);
				intent.putExtra("ICON", R.drawable.lv_salah);
				startActivity(intent);
				break;
			case 1:
				intent = new Intent(this, WorshipRewardContent.class);
				intent.putExtra("TITLE", R.string.row2_salah_sunna);
				intent.putExtra("DESC", R.raw.salah_sunna);
				intent.putExtra("FEQH", R.raw.salah_sunna_feqh);
				intent.putExtra("ICON", R.drawable.lv_salah);
				startActivity(intent);
				break;
			case 2: //qeyam still
				intent = new Intent(this, WorshipRewardContent.class);
				intent.putExtra("TITLE", R.string.row3_salah_qeyam);
				intent.putExtra("DESC", R.raw.salah_qeyam);
				intent.putExtra("FEQH", R.raw.salah_qeyam_feqh);
				intent.putExtra("ICON", R.drawable.lv_salah);
				startActivity(intent);
				break;
			case 3:
				intent = new Intent(this, WorshipRewardContent.class);
				intent.putExtra("TITLE", R.string.row4_salah_wetr);
				intent.putExtra("DESC", R.raw.salah_wetr);
				intent.putExtra("FEQH", R.raw.salah_wetr_feqh);
				intent.putExtra("ICON", R.drawable.lv_salah);
				startActivity(intent);
				break;
			case 4:
				intent = new Intent(this, WorshipRewardContent.class);
				intent.putExtra("TITLE", R.string.row5_salah_doha);
				intent.putExtra("DESC", R.raw.salah_doha);
				intent.putExtra("FEQH", R.raw.salah_doha_feqh);	
				intent.putExtra("ICON", R.drawable.lv_salah);
				startActivity(intent);
				break;
			case 5:
				intent = new Intent(this, WorshipRewardOnly.class);
				intent.putExtra("TITLE", R.string.row6_quran_qera2a);
				intent.putExtra("DESC", R.raw.quran_qeraaa);
				intent.putExtra("ICON", R.drawable.lv_quran);
				startActivity(intent);
				break;
			case 6:
				intent = new Intent(this, WorshipRewardOnly.class);
				intent.putExtra("TITLE", R.string.row7_quran_7efz);
				intent.putExtra("DESC", R.raw.quran_hefz);
				intent.putExtra("ICON", R.drawable.lv_quran);
				startActivity(intent);
				break;
			case 7: // zekr still
				intent = new Intent(this, WorshipRewardOnly.class);
				intent.putExtra("TITLE", R.string.row8_zekr_saba7_masa2);
				intent.putExtra("DESC", R.raw.zekr_sabah_masaa);
				intent.putExtra("ICON", R.drawable.lv_zekr);
				startActivity(intent);
				break;
			case 8:
				intent = new Intent(this, WorshipRewardContent.class);
				intent.putExtra("TITLE", R.string.row9_zekr_estykaz_nom);
				intent.putExtra("DESC", R.raw.zekr_estykaz);
				intent.putExtra("FEQH", R.raw.zekr_nom);
				intent.putExtra("ICON", R.drawable.lv_zekr);
				startActivity(intent);
				break;
			case 9:
				intent = new Intent(this, WorshipRewardContent.class);
				intent.putExtra("TITLE", R.string.row10_zekr_afterSalah);
				intent.putExtra("DESC", R.raw.zekr_aftersalah);
				intent.putExtra("FEQH", R.raw.zekr_aftersalah_feqh);	
				intent.putExtra("ICON", R.drawable.lv_zekr);
				startActivity(intent);
				break;
			case 10:
				intent = new Intent(this, WorshipRewardContent.class);
				intent.putExtra("TITLE", R.string.row11_sawm);
				intent.putExtra("DESC", R.raw.sawm);
				intent.putExtra("FEQH", R.raw.sawm_feqh);
				intent.putExtra("ICON", R.drawable.lv_sawm);
				startActivity(intent);
				break;
			default:
				break;
			}
		}
}
