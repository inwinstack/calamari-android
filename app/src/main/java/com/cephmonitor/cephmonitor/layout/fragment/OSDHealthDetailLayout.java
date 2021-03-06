package com.cephmonitor.cephmonitor.layout.fragment;

import android.content.Context;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.cephmonitor.cephmonitor.R;
import com.cephmonitor.cephmonitor.layout.ColorTable;
import com.cephmonitor.cephmonitor.layout.component.container.FractionAbleScrollView;
import com.cephmonitor.cephmonitor.layout.component.other.FloatLayoutLabel;
import com.cephmonitor.cephmonitor.model.app.theme.custom.manager.ThemeManager;
import com.cephmonitor.cephmonitor.model.app.theme.custom.prototype.DesignSpec;
import com.resourcelibrary.model.logic.RandomId;
import com.resourcelibrary.model.view.WH;

public class OSDHealthDetailLayout extends FractionAbleScrollView {
    private Context context;
    private WH ruler;
    private int dividerHeight;
    private DesignSpec designSpec;

    public RelativeLayout container;

    public TextView hostNameTitle;
    public TextView hostNameContent;
    public TextView publicIpTitle;
    public TextView publicIpContent;
    public TextView clusterIpTitle;
    public TextView clusterIpContent;
    public TextView poolsTitle;
    public FloatLayoutLabel poolLabels;
    public TextView reweightTitle;
    public ImageView reweightHelp;
    public TextView reweightContent;
    public TextView uuidTitle;
    public TextView uuidContent;

    public OSDHealthDetailLayout(Context context) {
        super(context);
        this.context = context;
        this.ruler = new WH(context);
        this.dividerHeight = ruler.getW(5);
        this.designSpec = ThemeManager.getStyle(getContext());

        LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        setId(RandomId.get());
        setLayoutParams(params);

        addView(container = container());
        container.addView(hostNameTitle = hostNameTitle());
        container.addView(hostNameContent = hostNameContent(hostNameTitle));
        container.addView(publicIpTitle = publicIpTitle(hostNameContent));
        container.addView(publicIpContent = publicIpContent(publicIpTitle));
        container.addView(clusterIpTitle = clusterIpTitle(publicIpContent));
        container.addView(clusterIpContent = clusterIpContent(clusterIpTitle));
        container.addView(poolsTitle = poolsTitle(clusterIpContent));
        container.addView(poolLabels = poolLabels(poolsTitle));
        container.addView(reweightTitle = reweightTitle(poolLabels));
        container.addView(reweightHelp = reweightHelp(reweightTitle));
        container.addView(reweightContent = reweightContent(reweightTitle));
        container.addView(uuidTitle = uuidTitle(reweightContent));
        container.addView(uuidContent = uuidContent(uuidTitle));
    }

    private RelativeLayout container() {
        ScrollView.LayoutParams params = new ScrollView.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);

        RelativeLayout v = new RelativeLayout(context);
        v.setId(RandomId.get());
        v.setLayoutParams(params);
        v.setPadding(dividerHeight, dividerHeight, dividerHeight, dividerHeight);

        return v;
    }

    private TextView hostNameTitle() {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.ALIGN_PARENT_TOP);

        TextView v = getTitle(R.string.osd_detail_host_name);
        v.setLayoutParams(params);

        return v;
    }

    private TextView hostNameContent(View topView) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, topView.getId());

        TextView v = getContent();
        v.setLayoutParams(params);

        return v;
    }

    private TextView publicIpTitle(View topView) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, topView.getId());
        params.setMargins(0, dividerHeight, 0, 0);

        TextView v = getTitle(R.string.osd_detail_public_ip);
        v.setLayoutParams(params);

        return v;
    }

    private TextView publicIpContent(View topView) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, topView.getId());

        TextView v = getContent();
        v.setLayoutParams(params);

        return v;
    }

    private TextView clusterIpTitle(View topView) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, topView.getId());
        params.setMargins(0, dividerHeight, 0, 0);

        TextView v = getTitle(R.string.osd_detail_cluster_ip);
        v.setLayoutParams(params);

        return v;
    }

    private TextView clusterIpContent(View topView) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, topView.getId());

        TextView v = getContent();
        v.setLayoutParams(params);

        return v;
    }

    private TextView poolsTitle(View topView) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, topView.getId());
        params.setMargins(0, dividerHeight, 0, 0);

        TextView v = getTitle(R.string.osd_detail_pools);
        v.setLayoutParams(params);

        return v;
    }

    private FloatLayoutLabel poolLabels(View topView) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 1);
        params.addRule(RelativeLayout.BELOW, topView.getId());

        FloatLayoutLabel v = new FloatLayoutLabel(context);
        v.setId(RandomId.get());
        v.setLayoutParams(params);
        v.setPadding(ruler.getW(3), ruler.getW(2));
        v.setMargin(ruler.getW(3), ruler.getW(3));

        return v;
    }

    private TextView reweightTitle(View topView) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, topView.getId());
        params.setMargins(0, dividerHeight, 0, 0);

        TextView v = getTitle(getContext().getString(R.string.osd_detail_re_weight) + "   ");
        v.setLayoutParams(params);

        return v;
    }

    private ImageView reweightHelp(final View leftView) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.RIGHT_OF, leftView.getId());
        params.addRule(RelativeLayout.ALIGN_TOP, leftView.getId());

        ImageView v = new ImageView(getContext()) {
            @Override
            protected void onSizeChanged(int w, int h, int oldw, int oldh) {
                super.onSizeChanged(w, h, oldw, oldh);
                int size = leftView.getHeight();
                if (size != h) {
                    RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams) getLayoutParams();
                    params.height = size;
                    params.width = size;
                    setLayoutParams(params);
                }
            }
        };
        v.setId(RandomId.get());
        v.setLayoutParams(params);
        v.setImageResource(R.drawable.icon044);

        return v;
    }

    private TextView reweightContent(View topView) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, topView.getId());

        TextView v = getContent();
        v.setLayoutParams(params);

        return v;
    }

    private TextView uuidTitle(View topView) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, topView.getId());
        params.setMargins(0, dividerHeight, 0, 0);

        TextView v = getTitle(R.string.osd_detail_uuid);
        v.setLayoutParams(params);

        return v;
    }

    private TextView uuidContent(View topView) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        params.addRule(RelativeLayout.BELOW, topView.getId());

        TextView v = getContent();
        v.setLayoutParams(params);

        return v;
    }

    private TextView getTitle(String text) {
        TextView v = new TextView(context);
        v.setId(RandomId.get());
        v.setTextSize(16);
        v.setGravity(Gravity.CENTER_VERTICAL);
        v.setTypeface(null, Typeface.BOLD);
        v.setTextColor(ColorTable._666666);
        v.setText(text);

        return v;
    }

    private TextView getTitle(int stringResource) {
        return getTitle(getContext().getString(stringResource));
    }

    private TextView getContent() {
        TextView v = new TextView(context);
        v.setId(RandomId.get());
        v.setTextSize(14);
        v.setGravity(Gravity.CENTER_VERTICAL);
        v.setTextColor(ColorTable._666666);
        v.setText(" ");

        return v;
    }
}
