package com.jkdajac.mypatients

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_list.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


/**
 * A simple [Fragment] subclass.
 * Use the [ListFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListFragment : Fragment(), PatientsListCallback {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private val patients = arrayListOf<Patient>(
        Patient("Peter", "Parker", "The overall goal of the UNC Inpatient Medicine" +
                " Clerkship is to have all students " +
                "develop " +
                "a comprehensive approach to the evaluation and care of the adult medical patient. " +
                "During the clerkship, students will " +
                "continue to improve their ability to obtain, record, analyze and communicate clinical" +
                " information. More specifically, " +
                "it is expected that all students, by the end of the Inpatient Clerkship will be able:\n" +
                "\n" +
                "to obtain an accurate, comprehensive history from the patient (PC3A1)\n" +
                "to perform a rational, thorough physical exam (PC3B1)\n" +
                "to, when appropriate, focus the history and physical exam to the patient’s active issues (PC3A1, PC3B1)\n" +
                "to order basic laboratory and radiologic studies as appropriate and to know how to interpret" +
                " the results of these studies (MK3D2, PC3D1)\n" +
                "to use information from the history, physical examination and initial laboratory " +
                "data to create a problem list (PC3E1)" +
                ""),
        Patient("Jehnsen", "Ackles", "The patients the students meet on the wards" +
                " and in the clinics should " +
                "be the focus for the development of these skills; the students’ contact with the " +
                "patients is the center of the curriculum.\n" +
                "\n" +
                "Students can monitor their progress by utilizing the RIME framework and by asking for " +
                "formative evaluation from their residents and attendings."),
        Patient("Ben", "Trudo", "The Liaison Committee on Medical Education (LCME)" +
                " is the agency that accredits medical schools in the United States. The LCME mandates" +
                " that “an institution that offers a medical education program must have in place a" +
                " system with central oversight to ensure that the faculty define the types of patients " +
                "and clinical conditions that medical students must encounter, the appropriate clinical" +
                " setting for the educational experiences, and the expected level of medical student " +
                "responsibility. The faculty must monitor medical student experiences and modify them as necessary to" +
                " ensure that the objectives of the medical education program are met.”"),
        Patient("Paul", "Seak", "The Liaison Committee on Medical Education (LCME)" +
                " is the agency that accredits medical schools in the United States. The LCME mandates " +
                "that “an institution that offers a medical education program must have in place a system" +
                " with central oversight to ensure that the faculty define the types of patients and " +
                "clinical conditions that medical students must encounter, the appropriate clinical" +
                " setting for the educational experiences, and the expected level of medical student" +
                " responsibility. The faculty must monitor medical student experiences and modify them " +
                "as necessary to ensure that the objectives of the" +
                " medical education program are met.”"),
        Patient("Rudolf", "Aiten", "As noted above, patient encounters will be" +
                " monitored by completion of the Clinical Log (on one45). At the midpoint of each of " +
                "the 3-week rotations, students will review the Clinical Log with their residents and" +
                " attendings. This will allow students to focus subsequent clinical encounters to maximize " +
                "the chance of a direct clinical experience with patients with the conditions listed above. " +
                "All students will also have an individual mid-clerkship meeting with the clerkship " +
                "director sometime during week 3 or week 4 of the clerkship. During that meeting each" +
                " student’s overall clinical experiences" +
                " will be discussed, including a review of the Clinical Log. "),
        Patient("George", "Restly", "The student would then review the case with " +
                "his/her resident and/or attending. Another option (much less desirable) is to have a " +
                "clinical discussion about the topic with the resident or attending or the clerkship" +
                " director (without the student seeing a patient individually). A given student can “miss”" +
                " having a direct clinical encounter with patients for only two of the above conditions. " +
                "They must have an indirect clinical encounter of some kind for these conditions. The extent of" +
                " the interaction will be documented in the Clinical Log."),
        Patient("Craig", "Johnson", "The 6-week inpatient Medicine Clerkship is " +
                "divided into two 3-week rotations. All students will spend at least one rotation at " +
                "UNC Hospitals in Chapel Hill. The majority of students will spend the other rotation" +
                " at one of the following AHEC sites: Carolinas Medical Center (Charlotte AHEC), Moses H." +
                " Cone Memorial Hospital (Greensboro AHEC), Wake County Medical Center (Wake AHEC) " +
                "or New Hanover Regional Medical Center (SEAHEC)."),
        Patient("Amanda", "Tapping", "Problem #2 Polycythemia Vera: three years ago," +
                " during a routine physical for work, the patient\n" +
                "was found to have elevated hemoglobin and was worked-up at LUMC by Dr. Smith. His red\n" +
                "blood cell mass was high and the patient was found to have primary Polycythemia Vera. Initially\n" +
                "he was treated with monthly phlebotomies, but for the last year has received a phlebotomy\n" +
                "only once every six months. He has no symptoms of this illness. "),
        Patient("Crisien", "Avasarala", "The patient is concerned that he has the same" +
                " problem that his father had and that he has the\n" +
                "same potential to \"drop dead\". He normally has sexual intercourse with his wife one to two\n" +
                "times per week, but because of the fear of having the pain during intercourse the patient has\n" +
                "avoided any intimate contact with his wife."),
        Patient("Jason", "Momoa", "HPI: Mr. PH is a 52 y/o accountant with hypercholesterolemia " +
                "and polycythemia vera who has\n" +
                "been in relatively good health (except for problem #2 below) until one month ago when he\n" +
                "noticed chest tightness with exertion. The patient decided to lose weight through exercising\n" +
                "and began to run. When running greater than six to seven blocks, the patient developed a tight\n" +
                "feeling in his chest that subsided in approximately five minutes after he stopped running. "),
        Patient("Steave", "Davis", ". On the night prior to admission, while watching TV, he had the\n" +
                "same pain, except this time it was of increased intensity (10/10), lasted 20 minutes, and was\n" +
                "associated with shortness of breath and a brief period of profuse diaphoresis. Regarding risk\n" +
                "factors for coronary artery disease, the patient does not smoke, has no high blood pressure or\n" +
                "diabetes, has borderline high cholesterol, and patient's father died suddenly at age 40 from a\n" +
                "presumed heart attack. "),
        Patient("Erik", "Kripke", "MEDICAL HISTORY\n" +
                "1. Adult Illnesses:\n" +
                "a. Polycythemia Vera – diagnosed incidentally three years ago. Currently\n" +
                "asymptomatic and treated every 6 months with phlebotomy.\n" +
                "b. Hypercholesterolemia – diagnosed by screening two years ago. Treated with\n" +
                "‘statin’ medication.\n" +
                "2. Health Screening: colonoscopy at LUMC 2009, no polyps\n" +
                "3. Immunizations – tetanus booster in 2016\n" +
                "4. Obstetric & Gynecologic History – N/A\n" +
                "5. Psychiatric Illnesses or Hospitalizations - none\n" +
                "6. Significant Childhood Illnesses - none")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (context != null) {
            rvPatients.adapter = PatientsAdapter(patients, requireContext(), this)
            rvPatients.layoutManager = LinearLayoutManager(context)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(
            param1: String,
            param2: String,

        ) =
            ListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }


    }

    override fun onItemSelected(index: Int) {
       activity?.supportFragmentManager
           ?.beginTransaction()
           ?.addToBackStack(null)
           ?.replace(R.id.flDetails, DetailsFragment.newInstance(
               patients[index].name, patients[index].lastname, patients[index].details))
           ?.commit()

    }
}

