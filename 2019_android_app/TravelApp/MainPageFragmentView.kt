package com.app.travel.ui.main.MainPage

// Main View
import android.view.View
import com.app.travel.travel20.MainActivity
import com.app.travel.travel20.R
import com.app.travel.travel20.databinding.FragmentHomeBinding

// layout
import android.support.v7.widget.GridLayoutManager

// UI components
import com.app.travel.base.BaseFragment

// dialog
import android.widget.Toast
import com.app.travel.widget.customDialog.Dialog
import com.app.travel.base.BaseDialog

//log
import android.util.Log

// Data Bundle
import android.os.Bundle

// other View to intent to
import android.content.Intent
import com.app.travel.ui.login.LoginActivity
import com.app.travel.ui.main.personal.coupon.CouponDetailActivity
import com.app.travel.ui.main.personal.coupon.CouponListActivity
import com.app.travel.ui.main.personal.customerService.CustomerServiceActivity

// Model
import com.app.travel.model.TravelAgentModel
import com.app.travel.model.response.CouponListModel

// Singleton of User Obj (only one Obj from Class)
import com.app.travel.util.*
import com.app.travel.util.helper.UserHelper

// use eventbus & native lifecycleObserver as chain-EventEmitter(Observer) 
import android.arch.lifecycle.Observer
import com.jeremyliao.liveeventbus.LiveEventBus

// Java util
import java.util.*

//
import com.bannerlayout.listener.OnBannerClickListener


class MainPageFragment : BaseFragment<MainPageViewModel, FragmentMainPageBinding>(HomeViewModel::class.java) {

    // Bundle with res/layout file
    override fun getLayoutRes(): Int = R.layout.fragment_mainPage

    // render view in onCreate phase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setCouponList()
        observeLogout()
        setIndexBannerList()
    }

    override fun onResume() {
        super.onResume()
        viewModel!!.getIndexBannerListRequest()
        viewModel!!.getcouponListRequest()

        //ignore this, they are created by default
        mBinding.imvLogin.visibility = if (isLogin()) View.GONE else View.VISIBLE
        mBinding.rlUserAccount.visibility = if (isLogin()) View.VISIBLE else View.GONE
        mBinding.tvUserAccount.text = UserHelper.instance().userName
        mBinding.imvUserLevelIcon.setImageResource(UserHelper.instance().userVipLevelIcon!!)
        mBinding.rlUserAccount.setOnClickListener {
            LiveEventBus.get().with(CHANGE_PAGE).postValue(3)
        }

        // change Screen
        mBinding.llHomeSale.setOnClickListener {
            val intent = Intent(activity, CouponListActivity::class.java)
            activity?.startActivity(intent)
        }

        // change Screen
        mBinding.llHomeService.setOnClickListener {
            val intent = Intent(activity, CustomerServiceActivity::class.java)
            activity?.startActivity(intent)
        }

        // change Screen
        mBinding.imvLogin.setOnClickListener {
            val intent = Intent(activity, LoginActivity::class.java)
            activity?.startActivity(intent)
        }

        // render Layout 
        mBinding.List.layoutManager = GridLayoutManager(activity, 2)

        // render recycleview table view (adapter)
        val adapter = TravelAgentListActivity(viewModel!!.setDefaultGameList())
        mBinding.travelAgentList.adapter = adapter
        adapter.setOnItemClickListener(object : TravelAgentListActivity.OnItemClickListener {
            override fun onItemClick(view: View, data: TravelAgentModel) {
                if(data.Code == TY){
                    ( activity as MainActivity).changeFragment(1)
                }
                Toast.makeText(activity, data.name, Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        mBinding.blBanner.removeHandler()
        mBinding.blSale.removeHandler()
    }

    // banner
    private fun setIndexBannerList() {
        viewModel!!.indexBannerList().observe(this, Observer { indexBannerList ->
            mBinding.blBanner.apply {
                delayTime = 2000
                dotsSelector = R.drawable.banner
                isVisibleDots = true
                showTipsBackgroundColor = true
                pageNumViewBottomMargin = 12
                pageNumViewLeftMargin = 12
                pageNumViewRightMargin = 12
                pageNumViewTopMargin = 12
                imageLoaderManager = BannerImageManager()
            }
                .initPageNumView()
                .initTips()
                .resource(indexBannerList!!)
                .switchBanner(true)
        })
    }

    // logout
    private fun observeLogout() {
        LiveEventBus.get()
            .with(LOGOUT, Boolean::class.java)
            .observe(this, Observer {
                mBinding.imvLogin.visibility = if (isLogin()) View.GONE else View.VISIBLE
                mBinding.rlUserAccount.visibility = if (isLogin()) View.VISIBLE else View.GONE
            })
    }

    // coupon
    private fun setCouponList() {
        viewModel!!.couponList().observe(this, Observer { couponList ->
            mBinding.blSale.apply {
                delayTime = 2000
                dotsSelector = R.drawable.banner
                isVisibleDots = true
                showTipsBackgroundColor = true
                pageNumViewBottomMargin = 12
                pageNumViewLeftMargin = 12
                pageNumViewRightMargin = 12
                pageNumViewTopMargin = 12
                imageLoaderManager = PromotionsImageManager()
                onBannerClickListener = object : OnBannerClickListener<CouponListModel> {
                    override fun onBannerClick(view: View, position: Int, model: CouponListModel) {
                        val intent = Intent(activity, PromotionDetailActivity::class.java)
                        intent.putExtra("itemData", couponList!![position])
                        startActivity(intent)
                    }
                }
            }
                .initPageNumView()
                .initTips()
                .resource(couponList!!)
                .switchBanner(true)
        })
    }

}