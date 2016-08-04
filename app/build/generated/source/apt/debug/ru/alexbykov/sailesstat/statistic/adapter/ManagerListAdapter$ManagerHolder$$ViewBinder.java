// Generated code from Butter Knife. Do not modify!
package ru.alexbykov.sailesstat.statistic.adapter;

import android.support.v7.widget.CardView;
import android.widget.TextView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ManagerListAdapter$ManagerHolder$$ViewBinder<T extends ManagerListAdapter.ManagerHolder> implements ViewBinder<T> {
  @Override
  public Unbinder bind(Finder finder, T target, Object source) {
    return new InnerUnbinder<>(target, finder, source);
  }

  protected static class InnerUnbinder<T extends ManagerListAdapter.ManagerHolder> implements Unbinder {
    protected T target;

    protected InnerUnbinder(T target, Finder finder, Object source) {
      this.target = target;

      target.managerName = finder.findRequiredViewAsType(source, 2131492991, "field 'managerName'", TextView.class);
      target.managerPlan = finder.findRequiredViewAsType(source, 2131492994, "field 'managerPlan'", TextView.class);
      target.managerQuantityOfMeetings = finder.findRequiredViewAsType(source, 2131492992, "field 'managerQuantityOfMeetings'", TextView.class);
      target.managerQuantityOfTenders = finder.findRequiredViewAsType(source, 2131492993, "field 'managerQuantityOfTenders'", TextView.class);
      target.cardView = finder.findRequiredViewAsType(source, 2131492990, "field 'cardView'", CardView.class);
    }

    @Override
    public void unbind() {
      T target = this.target;
      if (target == null) throw new IllegalStateException("Bindings already cleared.");

      target.managerName = null;
      target.managerPlan = null;
      target.managerQuantityOfMeetings = null;
      target.managerQuantityOfTenders = null;
      target.cardView = null;

      this.target = null;
    }
  }
}
