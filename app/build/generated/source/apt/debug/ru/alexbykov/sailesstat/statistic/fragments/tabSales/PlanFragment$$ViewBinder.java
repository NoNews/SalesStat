// Generated code from Butter Knife. Do not modify!
package ru.alexbykov.sailesstat.statistic.fragments.tabSales;

import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import com.akexorcist.roundcornerprogressbar.RoundCornerProgressBar;
import com.github.mikephil.charting.charts.PieChart;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class PlanFragment$$ViewBinder<T extends PlanFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(Finder finder, T target, Object source) {
    return new InnerUnbinder<>(target, finder, source);
  }

  protected static class InnerUnbinder<T extends PlanFragment> implements Unbinder {
    protected T target;

    protected InnerUnbinder(T target, Finder finder, Object source) {
      this.target = target;

      target.costsPieChart = finder.findRequiredViewAsType(source, 2131492981, "field 'costsPieChart'", PieChart.class);
      target.progressPlan = finder.findRequiredViewAsType(source, 2131492982, "field 'progressPlan'", RoundCornerProgressBar.class);
      target.percentPlanTextView = finder.findRequiredViewAsType(source, 2131492983, "field 'percentPlanTextView'", TextView.class);
    }

    @Override
    public void unbind() {
      T target = this.target;
      if (target == null) throw new IllegalStateException("Bindings already cleared.");

      target.costsPieChart = null;
      target.progressPlan = null;
      target.percentPlanTextView = null;

      this.target = null;
    }
  }
}
