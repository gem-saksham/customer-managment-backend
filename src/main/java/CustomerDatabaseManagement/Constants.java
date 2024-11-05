package CustomerDatabaseManagement;


import java.util.HashMap;
import java.util.List;
import java.util.Map;



public  class Constants {

    public static final String X_REMOTE_USER_EMAIL = "X-REMOTE-USER-EMAIL";



      public static final List<String> roles =
              List.of("Head Of Institution", "LibraryHead", "LibraryCommitteeChariman", "LibraryCommitteeMember",
                      "Faculty", "Reasearcher/Scientist", "Student", "Administrative staff", "Influencer");


      public static final Map<String, List<String>> subjectMap;

      static {
          subjectMap = new HashMap<>();
          subjectMap.put("Engineering and Technology", List.of("Architecture", "Computer Science", "Engineering",
                  "Material Science", "Technology"));

          subjectMap.put("Biomedical science", List.of("Life Sciences", "Biochemistry", "Genetics and Molecular Biology",
                  " Biotechnology," +
                          " Dentistry", "Medicine1", "Neuroscience", "Pharmacy", "Pharmacology", "Psychology", "Nursing"));

          subjectMap.put("Social sciences", List.of("Business and Management", "Psychology",
                  "Economics", "Finance", "Education", "Law", "Library and Information Science"));

          subjectMap.put("Agriculture", List.of("Breeding", "Crop & soil environmental Science",
                  "Dairy science & Technology,Ecology", "Entomology", "Farming systems & Quality",
                  "Fertilizers", "Food Science & Technology", "Forest Resources & Environmental Conservation",
                  "Genetics, bioinformatics, and computational biology", "Horticulture", "Hydrology", "Irrigation",
                  "Livestock", "Organic farming", "Pesticides & Pest Control", "Plant pathology ,physiology1, and weed science",
                  "Postharvest technology", "Animal genetics", "Animal nutrition", "Biodiversity",
                  "Biotechnology", "Epidemiology", "Genetics", "Immunology", "Insectology", "Marine Biology",
                  "Natural resources", "Plant Biology", "Plant pathology", "Plant products", "Vetrinary science",
                  "Viruses", "Viticulture", "Wildlife science", "Physical Anthropology", "Ecology & Biodiversity",
                  "Cytogenetics", "Molecular Biology", "Biophysics", "Biochemistry", "Virology", "Microbiology"));

          subjectMap.put("Basic Sciences", List.of("Chemistry", "Environmental Science", "Mathematics",
                  "Earth & Planetary Sciences", "Geology & Geophysics",
                  "Physics", "Statistics", "Biology", "Zoology"));


          subjectMap.put("Arts and Humanities", List.of("Anthropology", "Biography", "Culture Studies",
                  "Current Events", "Literature", "Nature", "Philosophy",
                  "Poetry & Drama", "Music", "Fashion & Entertainment",
                  "History and Classics", "Philosophy", "Theology and Religious Studies",
                  "Performing Arts and Theatre Studies",
                  "Anthropology", "Language & linguistics", "Global Development",
                  "Art History and Visual studies"));

          subjectMap.put("Multi-disciplinary", List.of(""));
      }
    public static final Map<String, List<String>>  marketMap;

    static {

        marketMap = new HashMap<>();

        marketMap.put("Corporate", List.of("Advertising and Market Research", "Agriculture, Horticulture And Forestry",
                "Architecture, Interior Decoration And Real Estate", "Automobile And Railway Equipment",
                "Banking, Financial And Insurance Services", "Chemical Industry", "Cinematographic Equipment," +
                        "Optical Instruments & Photography", "Communication Industry", "Construction And Allied Products",
                "Construction And Allied Products", "Consumer Goods", "Defence And Aerospace", "Drugs, Pharmaceuticals & Health Care",
                "Electrical Industry", "Energy, Power Generation & Transmission", "Engineering Industry", "Ferrous Metals",
                "Food, Beverage, Dairy, Confectionery & Tobacco", "Gems, Jewellery & Watches", "Glass & Packaging Industry",
                "Govt., Social, Political & Educational Institutions", "Hotel, Restaurants & Catering", "Information Technology Industry",
                "Leather And Allied Products", "Live Stock, Fish & Animal Related", "Mail & Transportation Services",
                "Mining, Minerals & Metallurgy", "Miscellaneous Products And Services", "Non Ferrous Metals", "Oil And Natural Gas",
                "Oils & Fats", "Paints & Surface Coatings", "Paper Industry", "Pollution Control Including Waste Management",
                "Polymers And Plastics", "Printing & Publishing", "Refrigeration & Air-conditioning", "Rubber Industry",
                "Shipping Industry", "Soaps, Detergents & Cosmetics", "Sugar Industry", "Textile Industry"));

        marketMap.put("Corporate R & D", List.of("Pharmaceutical R & D", "Manufacturing R & D", "Others"));

        marketMap.put("Academic", List.of("Universities"
                , "Engineering Colleges", "Management Colleges", "Medical Colleges", "Pharma Colleges", "Dental colleges",
                "Nursing Colleges", "Paramedical Colleges", "Arts and Commerce Colleges", "Science Colleges", "Professional and Vocational Colleges", "Schools"));

        marketMap.put("Government", List.of("Ministries – Central", "Ministries – State", "Government departments – Centre", "Government departments - State"));

        marketMap.put("Government Research", List.of("CSIR", "DAE", "DST", "DRDO", "DOD", "ISRO", "ICAR", "Environment - ICFRE (Forestry)"));

        marketMap.put("Public Sector", List.of(""));
    }

        public static final Map<String, List<String>> academicMap ;

        static {
            academicMap = new HashMap<>();
        academicMap.put("UGC", List.of(""));
        }
    }

