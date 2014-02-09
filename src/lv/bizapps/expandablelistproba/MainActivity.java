package lv.bizapps.expandablelistproba;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class MainActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ExpandableListView elv = (ExpandableListView)findViewById(R.id.expandableListView1);
		elv.setAdapter(new MyAdapter(getApplicationContext()));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

	class MyAdapter extends BaseExpandableListAdapter {
		protected Context ctx;
		protected LayoutInflater inflater;

		public MyAdapter(Context ctx) {
			this.ctx = ctx;
			this.inflater = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public Object getChild(int groupPosition, int childPosition) {
			return childPosition;
		}

		@Override
		public long getChildId(int groupPosition, int childPosition) {
			return childPosition;
		}

		@Override
		public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View view, ViewGroup viewGroup) {
			view = this.inflater.inflate(R.layout.child_item, viewGroup, false);
					//this.inflater.inflate(android.R.layout.simple_expandable_list_item_2, viewGroup, false);

			TextView tv = (TextView)view.findViewById(R.id.textView2);
			tv.setTextColor(Color.BLACK);
			tv.setText("CHILD POS: "+groupPosition+":"+childPosition);

			return view;
		}

		@Override
		public int getChildrenCount(int groupPosition) {
			return 5;
		}

		@Override
		public Object getGroup(int groupPosition) {
			return groupPosition;
		}

		@Override
		public int getGroupCount() {
			return 3;
		}

		@Override
		public long getGroupId(int groupPosition) {
			return groupPosition;
		}

		@Override
		public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
			convertView = this.inflater.inflate(R.layout.exp_header, parent, false);
							//this.inflater.inflate( android.R.layout.simple_expandable_list_item_1, parent, false);

			//TextView tv = (TextView)convertView.findViewById(android.R.id.text1);
			TextView tv = (TextView)convertView.findViewById(R.id.textView1);
			tv.setTextColor(Color.BLACK);
			tv.setText("POS: "+groupPosition);

			return convertView;
		}

		@Override
		public boolean hasStableIds() {
			return false;
		}

		public boolean isChildSelectable(int groupPosition, int childPosition) {
			if(groupPosition == 1) return false;
			else return true;
		}
	}
}
