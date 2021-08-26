package com.swiftoffice.msaknowledgebank;


import android.content.Context;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.swiftoffice.msaknowledgebank.R;

import java.util.HashMap;
import java.util.List;

public class ExpendableMSAAdapter extends BaseExpandableListAdapter {
    private Context MSAContext;
    private ImageView imgElement;
    private List<String> MSA_Elements;
    private HashMap<String, List<String>> MSA_SubElements;
    private String MSA_Elements_String, MSA_SubElements_String;
    private TextView txtMSAChapters, txtMSASubChapters;
    public ExpendableMSAAdapter(Context context, List<String> listElements,
                                HashMap<String, List<String>> listSubElements) {
        MSAContext = context;
        MSA_Elements = listElements;
        MSA_SubElements = listSubElements;
    }
    @Override
    public int getGroupCount() {
        return MSA_Elements.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return MSA_SubElements.get(MSA_Elements.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return MSA_Elements.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return MSA_SubElements.get(MSA_Elements.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        MSA_Elements_String = (String) getGroup(groupPosition);
        LayoutInflater layoutInflater = (LayoutInflater) MSAContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.list_elements, null);
        txtMSAChapters = (TextView) convertView.findViewById(R.id.txtMSAElements);
        SpannableString underline = new SpannableString(MSA_Elements_String);
        underline.setSpan(new UnderlineSpan(), 0, underline.length(), 0);
        txtMSAChapters.setText(underline);
        imgElement = (ImageView) convertView.findViewById(R.id.imgElement);
        if (MSA_Elements_String.equals("1.1 Locking/Fastening Devices")) {
            imgElement.setImageResource(R.drawable.aircraft_fastener);
        }
        else if ((MSA_Elements_String.equals("1.2 Leak Control"))) {
            imgElement.setImageResource(R.drawable.oring);
        }
        else if ((MSA_Elements_String.equals("1.3 Pipeline Handling"))) {
            imgElement.setImageResource(R.drawable.coupling);
        }
        else if ((MSA_Elements_String.equals("1.4 Aircraft/Component Protection"))) {
            imgElement.setImageResource(R.drawable.protection);
        }
        else if ((MSA_Elements_String.equals("2.1 Cable Control"))) {
            imgElement.setImageResource(R.drawable.cablecontrol);
        }
        else if ((MSA_Elements_String.equals("2.2 Wheel/Brakes/Tire"))) {
            imgElement.setImageResource(R.drawable.tire);
        }
        else if ((MSA_Elements_String.equals("2.3 Compressor/Turbine"))) {
            imgElement.setImageResource(R.drawable.compressor);
        }
        else if ((MSA_Elements_String.equals("2.4 Fuel System"))) {
            imgElement.setImageResource(R.drawable.fuel);
        }
        else if ((MSA_Elements_String.equals("2.5 Arresters Systems"))) {
            imgElement.setImageResource(R.drawable.arresting);
        }
        else if ((MSA_Elements_String.equals("3.1 Wire Repair"))) {
            imgElement.setImageResource(R.drawable.repair);
        }
        else if ((MSA_Elements_String.equals("3.2 Wire Security/Mounting"))) {
            imgElement.setImageResource(R.drawable.aircraft_wire);
        }
        else if ((MSA_Elements_String.equals("3.3 Connectors"))) {
            imgElement.setImageResource(R.drawable.connector);
        }
        else if ((MSA_Elements_String.equals("3.4 Electrical Measurement"))) {
            imgElement.setImageResource(R.drawable.micrometer);
        }
        else if ((MSA_Elements_String.equals("4.1 Explosive Safety"))) {
            imgElement.setImageResource(R.drawable.munition);
        }
        else if ((MSA_Elements_String.equals("4.2 Explosive Store House"))) {
            imgElement.setImageResource(R.drawable.storehouse);
        }
        else if ((MSA_Elements_String.equals("4.3 General Weapons"))) {
            imgElement.setImageResource(R.drawable.chaff);
        }
        else if ((MSA_Elements_String.equals("5.1 Airframe"))) {
            imgElement.setImageResource(R.drawable.airframe);
        }
        else if ((MSA_Elements_String.equals("5.2 Engine"))) {
            imgElement.setImageResource(R.drawable.engine);
        }
        else if ((MSA_Elements_String.equals("5.3 Avionics"))) {
            imgElement.setImageResource(R.drawable.avionics);
        }
        else if ((MSA_Elements_String.equals("6.1 Wrenches"))) {
            imgElement.setImageResource(R.drawable.wrenches);
        }
        else if ((MSA_Elements_String.equals("6.2 Handles/Adapters"))) {
            imgElement.setImageResource(R.drawable.handle);
        }
        else if ((MSA_Elements_String.equals("6.3 Measuring Tools"))) {
            imgElement.setImageResource(R.drawable.measuring);
        }
        else if ((MSA_Elements_String.equals("6.4 Pliers"))) {
            imgElement.setImageResource(R.drawable.pliers);
        }
        else if ((MSA_Elements_String.equals("6.5 Miscellaneous Tools"))) {
            imgElement.setImageResource(R.drawable.misc);
        }
        else if ((MSA_Elements_String.equals("7.1 Avionics Testers"))) {
            imgElement.setImageResource(R.drawable.avionics_tester);
        }
        else if ((MSA_Elements_String.equals("7.2 Wire Repair Tools"))) {
            imgElement.setImageResource(R.drawable.repair_tools);
        }
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        MSA_SubElements_String = (String) getChild(groupPosition, childPosition);
        LayoutInflater layoutInflater = (LayoutInflater) MSAContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = layoutInflater.inflate(R.layout.list_subelements, null);
        txtMSASubChapters = (TextView) convertView.findViewById(R.id.txtMSASubElements);
        txtMSASubChapters.setText(MSA_SubElements_String);
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
