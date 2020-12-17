package com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.view.controller.epoxyModel

import android.view.View
import androidx.core.content.ContextCompat
import androidx.databinding.ViewDataBinding
import com.airbnb.epoxy.DataBindingEpoxyModel
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestBuilder
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.BaseRequestOptions
import com.bumptech.glide.request.RequestOptions
import com.relevanttech.bdjobs_mvvm.R
import com.relevanttech.bdjobs_mvvm.apps.ui.features.jobs.model.JobsItem
import com.relevanttech.bdjobs_mvvm.apps.utlis.GeneralHelper
import com.relevanttech.bdjobs_mvvm.databinding.ItemJoblistBinding

/**
 * Bismillah Hir Rahman Nir Raheem
 */

@EpoxyModelClass
abstract class JobsEpoxyModel : DataBindingEpoxyModel() {
    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    var listener: View.OnClickListener? = null

    var model: JobsItem? = null
    override fun getDefaultLayout(): Int = R.layout.item_joblist


    override fun setDataBindingVariables(binding: ViewDataBinding?) {

    }

    override fun bind(holder: DataBindingHolder) {
        super.bind(holder)

        val binding: ItemJoblistBinding = holder.dataBinding as ItemJoblistBinding
        binding.txtPositionName.text = model?.jobTitle
        binding.txtDeadlineDate.text = GeneralHelper.formateDateFromstring(
            "MM/dd/yyyy",
            "d MMM yyyy",
            model?.deadline.toString()
        )
        binding.txtCompanyName.text = model?.recruitingCompanySProfile.toString()
        (((Glide.with(binding.root).load(model?.logo.toString())
            .skipMemoryCache(true) as RequestBuilder<*>).apply(
            (RequestOptions().override(260, 260) as BaseRequestOptions<*>)
        ).diskCacheStrategy(DiskCacheStrategy.RESOURCE) as RequestBuilder<*>).placeholder(
            ContextCompat.getDrawable(
                binding.root.context,
                R.drawable.logo
            )
        ) as RequestBuilder<*>).into(binding.imgCompanyLogo)
        if (model?.minExperience == null && model?.maxExperience == null) {
            binding.txtYearOfExperience.text = "Na"
        } else if (model?.minExperience != null && model?.maxExperience == null) {
            binding.txtYearOfExperience.text = "At least ${model?.minExperience.toString()} year(s)"
        } else if (model?.minExperience == null && model?.maxExperience != null) {
            binding.txtYearOfExperience.text = "At most ${model?.maxExperience.toString()} year(s)"
        } else if (model?.minExperience != null && model?.maxExperience != null) {
            binding.txtYearOfExperience.text =
                "${model?.minExperience.toString()} to ${model?.maxExperience.toString()} year(s)"
        }

        if (model?.isFeatured == true) {
            binding.constraintLayout.setBackgroundColor(
                ContextCompat.getColor(
                    binding.root.context,
                    R.color.transYallow
                )
            )
        }
        binding.constraintLayout.setOnClickListener(listener)

    }

    override fun unbind(dataBindingHolder: DataBindingHolder) {
        super.unbind(dataBindingHolder)
        dataBindingHolder.dataBinding.unbind()
    }
}