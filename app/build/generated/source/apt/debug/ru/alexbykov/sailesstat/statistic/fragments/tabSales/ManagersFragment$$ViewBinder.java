// Generated code from Butter Knife. Do not modify!
package ru.alexbykov.sailesstat.statistic.fragments.tabSales;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class ManagersFragment$$ViewBinder<T extends ManagersFragment> implements ViewBinder<T> {
  @Override
  public Unbinder bind(Finder finder, T target, Object source) {
    return new InnerUnbinder<>(target, finder, source);
  }

  protected static class InnerUnbinder<T extends ManagersFragment> implements Unbinder {
    protected T target;

    protected InnerUnbinder(T target, Finder finder, Object source) {
      this.target = target;

      target.managersRecyclerView = finder.findRequiredViewAsType(source, 2131492980, "field 'managersRecyclerView'", RecyclerView.class);
      target.managersSwipe = finder.findRequiredViewAsType(source, 2131492979, "field 'managersSwipe'", SwipeRefreshLayout.class);
    }

    @Override
    public void unbind() {
      T target = this.target;
      if (target == null) throw new IllegalStateException("Bindings already cleared.");

      target.managersRecyclerView = null;
      target.managersSwipe = null;

      this.target = null;
    }
  }
}
