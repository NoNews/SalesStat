// Generated code from Butter Knife. Do not modify!
package ru.alexbykov.sailesstat;

import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.Toolbar;
import butterknife.Unbinder;
import butterknife.internal.Finder;
import butterknife.internal.ViewBinder;
import java.lang.IllegalStateException;
import java.lang.Object;
import java.lang.Override;

public class FatherActivity$$ViewBinder<T extends FatherActivity> implements ViewBinder<T> {
  @Override
  public Unbinder bind(Finder finder, T target, Object source) {
    return new InnerUnbinder<>(target, finder, source);
  }

  protected static class InnerUnbinder<T extends FatherActivity> implements Unbinder {
    protected T target;

    protected InnerUnbinder(T target, Finder finder, Object source) {
      this.target = target;

      target.toolbar = finder.findRequiredViewAsType(source, 2131493011, "field 'toolbar'", Toolbar.class);
      target.navigationView = finder.findRequiredViewAsType(source, 2131492994, "field 'navigationView'", NavigationView.class);
      target.drawerLayout = finder.findRequiredViewAsType(source, 2131492969, "field 'drawerLayout'", DrawerLayout.class);
      target.viewPager = finder.findRequiredViewAsType(source, 2131493010, "field 'viewPager'", ViewPager.class);
      target.tabLayout = finder.findRequiredViewAsType(source, 2131493009, "field 'tabLayout'", TabLayout.class);
    }

    @Override
    public void unbind() {
      T target = this.target;
      if (target == null) throw new IllegalStateException("Bindings already cleared.");

      target.toolbar = null;
      target.navigationView = null;
      target.drawerLayout = null;
      target.viewPager = null;
      target.tabLayout = null;

      this.target = null;
    }
  }
}
