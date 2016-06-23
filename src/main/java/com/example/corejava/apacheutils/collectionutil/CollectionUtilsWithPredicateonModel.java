package com.example.corejava.apacheutils.collectionutil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.Predicate;


import com.example.common.pojo.ModelSub;

public class CollectionUtilsWithPredicateonModel 
{
		public static void main(String[] args) {
			ModelSub s=new ModelSub();
			ModelSub s1=new ModelSub();
			ModelSub s2=new ModelSub();
			ModelSub s3=new ModelSub();
			s.setUid("A");
			s.setUname("tarun");
			s1.setUid("B");
			s1.setUname("tarun");
			s2.setUid("C");
			s2.setUname("arun");
			s3.setUid("D");
			s3.setUname("varun");
			
			List fullList = new ArrayList();
			fullList.add(s);
			fullList.add(s1);
			fullList.add(s2);
			fullList.add(s3);
			
			String IdStr = "A,B,C,D,E,F,G";
			final String[] carrierId =IdStr.split(",");
			final List<ModelSub> modList = new ArrayList<ModelSub>();
			
			System.out.println("=========CollectioUtils.find===============");
			CollectionUtils.find(fullList, new Predicate() {
				@Override
				public boolean evaluate(Object res) {
					ModelSub cr = (ModelSub) res;
					String repId = cr.getUid();
					String repName = cr.getUname();
					for (String curToken : carrierId) {
						if (repId.equalsIgnoreCase(curToken.trim()) && repName.equalsIgnoreCase("tarun"))
							modList.add(cr);
					}
					return false;
				}
			});
			System.out.println(modList);
			
			System.out.println("=========CollectioUtils.select===============");
			fullList = new ArrayList();
			fullList.add(s);
			fullList.add(s1);
			fullList.add(s2);
			fullList.add(s3);
			
			Collection selectedItemResponses = CollectionUtils
			.select(fullList, new Predicate() {

				public boolean evaluate(Object object) {
					ModelSub s = (ModelSub) object;
					return( ( s.getUid().equals( "A" ) ) ||
				            ( s.getUid().equals( "B" ) && 
				              s.getUname() == "tarun" ) );
				}

			});
			System.out.println("selectedItemResponses "+selectedItemResponses);
			
			System.out.println("=========CollectioUtils.filter===============");
			List newList = new ArrayList();
			newList.add(s);
			newList.add(s1);
			newList.add(s2);
			newList.add(s3);
			System.out.println("before "+newList);
			CollectionUtils.filter(newList, new Predicate() {

				public boolean evaluate(Object object) {
					ModelSub s = (ModelSub) object;
					return( ( s.getUid().equals( "A" ) ) ||
				            ( s.getUid().equals( "B" ) && 
				              s.getUname() == "tarun" ) );
				}

			});
			System.out.println("after "+newList);
			
			
			System.out.println("=========CollectioUtils.exists -- with Set===============");
			
			final String uname = "varun";
			Set<ModelSub> newSet = new HashSet<ModelSub>();
			newSet.add(s);
			newSet.add(s1);
			newSet.add(s2);
			newSet.add(s3);
			boolean allowed = CollectionUtils.exists(newSet,
					new Predicate() {

						public boolean evaluate(Object o) {
							ModelSub cc = (ModelSub) o;
							return cc.getUname().equals(uname);
						}
					});
			System.out.println("allowed with set::: "+allowed);
			
			
			System.out.println("=========CollectioUtils.exists -- with List===============");
			List<ModelSub> lst = new ArrayList<ModelSub>();
			newSet.add(s);
			newSet.add(s1);
			newSet.add(s2);
			newSet.add(s3);
			boolean allowed1 = CollectionUtils.exists(lst,
					new Predicate() {

						public boolean evaluate(Object o) {
							ModelSub cc = (ModelSub) o;
							return cc.getUname().equals(uname);
						}
					});
			System.out.println("allowed with list:::: "+allowed);
		}
}
