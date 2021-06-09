--
-- PostgreSQL database dump
--

-- Dumped from database version 12.3
-- Dumped by pg_dump version 12.3

-- Started on 2021-06-09 19:57:04

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- TOC entry 202 (class 1259 OID 16394)
-- Name: admin; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.admin (
    idadmin integer NOT NULL,
    login character varying(254),
    mdp character varying(254),
    nom character varying(254),
    tel character varying(254),
    email character varying(254)
);


ALTER TABLE public.admin OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16400)
-- Name: affecter; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.affecter (
    idadmin integer NOT NULL,
    idens integer NOT NULL
);


ALTER TABLE public.affecter OWNER TO postgres;

--
-- TOC entry 204 (class 1259 OID 16403)
-- Name: application; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.application (
    idappli integer NOT NULL,
    nom character varying(254),
    description text
);


ALTER TABLE public.application OWNER TO postgres;

--
-- TOC entry 205 (class 1259 OID 16409)
-- Name: commentaire; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.commentaire (
    iderreur bigint NOT NULL,
    idmembre bigint NOT NULL,
    contenu text,
    heurearr date,
    lu boolean,
    datelu date,
    id_com bigint NOT NULL
);


ALTER TABLE public.commentaire OWNER TO postgres;

--
-- TOC entry 206 (class 1259 OID 16415)
-- Name: employe; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.employe (
    idemp integer NOT NULL,
    idposte integer NOT NULL,
    idens integer,
    nom character varying(254),
    prenom character varying(254),
    login character varying(254),
    mdp character varying(254)
);


ALTER TABLE public.employe OWNER TO postgres;

--
-- TOC entry 207 (class 1259 OID 16421)
-- Name: entreprise; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.entreprise (
    idens integer NOT NULL,
    raison character varying(254)
);


ALTER TABLE public.entreprise OWNER TO postgres;

--
-- TOC entry 208 (class 1259 OID 16424)
-- Name: erreur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.erreur (
    iderreur bigint NOT NULL,
    idappli integer NOT NULL,
    idtype integer NOT NULL,
    idstatut integer,
    idemp integer,
    idadmin integer NOT NULL,
    idgravite integer NOT NULL,
    titre character varying(254),
    description text,
    datedeclarer date,
    resolu boolean,
    dateresolu date,
    lu boolean,
    datelu date
);


ALTER TABLE public.erreur OWNER TO postgres;

--
-- TOC entry 2979 (class 0 OID 0)
-- Dependencies: 208
-- Name: TABLE erreur; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.erreur IS 'est considéré en meme temps comme un groupe';


--
-- TOC entry 209 (class 1259 OID 16430)
-- Name: gerer; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.gerer (
    idadmin integer NOT NULL,
    idappli integer NOT NULL,
    role character varying(254)
);


ALTER TABLE public.gerer OWNER TO postgres;

--
-- TOC entry 210 (class 1259 OID 16433)
-- Name: gravite; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.gravite (
    idgravite integer NOT NULL,
    libele character varying(254),
    descgravite character varying(254),
    background character varying(254)
);


ALTER TABLE public.gravite OWNER TO postgres;

--
-- TOC entry 2980 (class 0 OID 0)
-- Dependencies: 210
-- Name: TABLE gravite; Type: COMMENT; Schema: public; Owner: postgres
--

COMMENT ON TABLE public.gravite IS 'Niveau d''urgence';


--
-- TOC entry 211 (class 1259 OID 16439)
-- Name: membre; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.membre (
    idmembre bigint NOT NULL,
    idemp integer,
    idadmin integer,
    nom character varying(254),
    prenom character varying(254),
    type_membre character varying(254)
);


ALTER TABLE public.membre OWNER TO postgres;

--
-- TOC entry 212 (class 1259 OID 16445)
-- Name: piece; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.piece (
    idpiece integer NOT NULL,
    iderreur bigint,
    com_iderreur bigint,
    idmembre bigint,
    nom character varying(254),
    type character varying(254),
    emplacement character varying(254)
);


ALTER TABLE public.piece OWNER TO postgres;

--
-- TOC entry 213 (class 1259 OID 16451)
-- Name: pocede; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.pocede (
    idens integer NOT NULL,
    idappli integer NOT NULL
);


ALTER TABLE public.pocede OWNER TO postgres;

--
-- TOC entry 214 (class 1259 OID 16454)
-- Name: poste; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.poste (
    idposte integer NOT NULL,
    denomination character varying(254)
);


ALTER TABLE public.poste OWNER TO postgres;

--
-- TOC entry 215 (class 1259 OID 16457)
-- Name: statut; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.statut (
    idstatut integer NOT NULL,
    libele character varying(254),
    description text,
    style character varying(254)
);


ALTER TABLE public.statut OWNER TO postgres;

--
-- TOC entry 216 (class 1259 OID 16463)
-- Name: transfert; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.transfert (
    idadmin integer NOT NULL,
    iderreur bigint NOT NULL,
    receveur integer,
    datetransfert date,
    motif character varying(254)
);


ALTER TABLE public.transfert OWNER TO postgres;

--
-- TOC entry 217 (class 1259 OID 16466)
-- Name: typeerreur; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.typeerreur (
    idtype integer NOT NULL,
    libele character varying(254),
    description character varying(254)
);


ALTER TABLE public.typeerreur OWNER TO postgres;

--
-- TOC entry 2757 (class 2606 OID 16473)
-- Name: admin pk_admin; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.admin
    ADD CONSTRAINT pk_admin PRIMARY KEY (idadmin);


--
-- TOC entry 2762 (class 2606 OID 16475)
-- Name: affecter pk_affecter; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.affecter
    ADD CONSTRAINT pk_affecter PRIMARY KEY (idadmin, idens);


--
-- TOC entry 2765 (class 2606 OID 16477)
-- Name: application pk_application; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.application
    ADD CONSTRAINT pk_application PRIMARY KEY (idappli);


--
-- TOC entry 2770 (class 2606 OID 16479)
-- Name: commentaire pk_commentaire; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT pk_commentaire PRIMARY KEY (id_com);


--
-- TOC entry 2775 (class 2606 OID 16481)
-- Name: employe pk_employe; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employe
    ADD CONSTRAINT pk_employe PRIMARY KEY (idemp);


--
-- TOC entry 2778 (class 2606 OID 16483)
-- Name: entreprise pk_entreprise; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.entreprise
    ADD CONSTRAINT pk_entreprise PRIMARY KEY (idens);


--
-- TOC entry 2787 (class 2606 OID 16485)
-- Name: erreur pk_erreur; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.erreur
    ADD CONSTRAINT pk_erreur PRIMARY KEY (iderreur);


--
-- TOC entry 2792 (class 2606 OID 16487)
-- Name: gerer pk_gerer; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gerer
    ADD CONSTRAINT pk_gerer PRIMARY KEY (idadmin, idappli);


--
-- TOC entry 2795 (class 2606 OID 16489)
-- Name: gravite pk_gravite; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gravite
    ADD CONSTRAINT pk_gravite PRIMARY KEY (idgravite);


--
-- TOC entry 2800 (class 2606 OID 16491)
-- Name: membre pk_membre; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membre
    ADD CONSTRAINT pk_membre PRIMARY KEY (idmembre);


--
-- TOC entry 2805 (class 2606 OID 16493)
-- Name: piece pk_piece; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.piece
    ADD CONSTRAINT pk_piece PRIMARY KEY (idpiece);


--
-- TOC entry 2807 (class 2606 OID 16495)
-- Name: pocede pk_pocede; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pocede
    ADD CONSTRAINT pk_pocede PRIMARY KEY (idens, idappli);


--
-- TOC entry 2812 (class 2606 OID 16497)
-- Name: poste pk_poste; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.poste
    ADD CONSTRAINT pk_poste PRIMARY KEY (idposte);


--
-- TOC entry 2815 (class 2606 OID 16499)
-- Name: statut pk_statut; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.statut
    ADD CONSTRAINT pk_statut PRIMARY KEY (idstatut);


--
-- TOC entry 2820 (class 2606 OID 16501)
-- Name: transfert pk_transfert; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transfert
    ADD CONSTRAINT pk_transfert PRIMARY KEY (idadmin, iderreur);


--
-- TOC entry 2824 (class 2606 OID 16503)
-- Name: typeerreur pk_typeerreur; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.typeerreur
    ADD CONSTRAINT pk_typeerreur PRIMARY KEY (idtype);


--
-- TOC entry 2755 (class 1259 OID 16504)
-- Name: admin_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX admin_pk ON public.admin USING btree (idadmin);


--
-- TOC entry 2788 (class 1259 OID 16505)
-- Name: administrer_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX administrer_fk ON public.gerer USING btree (idadmin);


--
-- TOC entry 2789 (class 1259 OID 16506)
-- Name: administrer_fk2; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX administrer_fk2 ON public.gerer USING btree (idappli);


--
-- TOC entry 2758 (class 1259 OID 16507)
-- Name: affecter_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX affecter_fk ON public.affecter USING btree (idadmin);


--
-- TOC entry 2759 (class 1259 OID 16508)
-- Name: affecter_fk2; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX affecter_fk2 ON public.affecter USING btree (idens);


--
-- TOC entry 2760 (class 1259 OID 16509)
-- Name: affecter_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX affecter_pk ON public.affecter USING btree (idadmin, idens);


--
-- TOC entry 2763 (class 1259 OID 16510)
-- Name: application_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX application_pk ON public.application USING btree (idappli);


--
-- TOC entry 2779 (class 1259 OID 16511)
-- Name: association10_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association10_fk ON public.erreur USING btree (idadmin);


--
-- TOC entry 2771 (class 1259 OID 16512)
-- Name: association12_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association12_fk ON public.employe USING btree (idens);


--
-- TOC entry 2772 (class 1259 OID 16513)
-- Name: association13_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association13_fk ON public.employe USING btree (idposte);


--
-- TOC entry 2780 (class 1259 OID 16514)
-- Name: association14_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association14_fk ON public.erreur USING btree (idgravite);


--
-- TOC entry 2817 (class 1259 OID 16515)
-- Name: association15_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association15_fk ON public.transfert USING btree (idadmin);


--
-- TOC entry 2781 (class 1259 OID 16516)
-- Name: association16_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association16_fk ON public.erreur USING btree (idappli);


--
-- TOC entry 2801 (class 1259 OID 16517)
-- Name: association17_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association17_fk ON public.piece USING btree (iderreur);


--
-- TOC entry 2782 (class 1259 OID 16518)
-- Name: association18_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association18_fk ON public.erreur USING btree (idtype);


--
-- TOC entry 2818 (class 1259 OID 16519)
-- Name: association19_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association19_fk ON public.transfert USING btree (receveur);


--
-- TOC entry 2783 (class 1259 OID 16520)
-- Name: association2_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association2_fk ON public.erreur USING btree (idstatut);


--
-- TOC entry 2802 (class 1259 OID 16521)
-- Name: association7_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX association7_fk ON public.piece USING btree (com_iderreur, idmembre);


--
-- TOC entry 2766 (class 1259 OID 16522)
-- Name: commentaire_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX commentaire_pk ON public.commentaire USING btree (id_com);


--
-- TOC entry 2767 (class 1259 OID 16523)
-- Name: commenter_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX commenter_fk ON public.commentaire USING btree (iderreur);


--
-- TOC entry 2768 (class 1259 OID 16524)
-- Name: commenter_fk2; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX commenter_fk2 ON public.commentaire USING btree (idmembre);


--
-- TOC entry 2784 (class 1259 OID 16525)
-- Name: declarer_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX declarer_fk ON public.erreur USING btree (idemp);


--
-- TOC entry 2773 (class 1259 OID 16526)
-- Name: employe_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX employe_pk ON public.employe USING btree (idemp);


--
-- TOC entry 2776 (class 1259 OID 16527)
-- Name: entreprise_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX entreprise_pk ON public.entreprise USING btree (idens);


--
-- TOC entry 2785 (class 1259 OID 16528)
-- Name: erreur_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX erreur_pk ON public.erreur USING btree (iderreur);


--
-- TOC entry 2790 (class 1259 OID 16529)
-- Name: gerer_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX gerer_pk ON public.gerer USING btree (idadmin, idappli);


--
-- TOC entry 2793 (class 1259 OID 16530)
-- Name: gravite_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX gravite_pk ON public.gravite USING btree (idgravite);


--
-- TOC entry 2796 (class 1259 OID 16531)
-- Name: membre_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX membre_pk ON public.membre USING btree (idmembre);


--
-- TOC entry 2797 (class 1259 OID 16532)
-- Name: peuretre_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX peuretre_fk ON public.membre USING btree (idadmin);


--
-- TOC entry 2798 (class 1259 OID 16533)
-- Name: peutetre_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX peutetre_fk ON public.membre USING btree (idemp);


--
-- TOC entry 2803 (class 1259 OID 16534)
-- Name: piece_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX piece_pk ON public.piece USING btree (idpiece);


--
-- TOC entry 2808 (class 1259 OID 16535)
-- Name: pocede_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX pocede_fk ON public.pocede USING btree (idens);


--
-- TOC entry 2809 (class 1259 OID 16536)
-- Name: pocede_fk2; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX pocede_fk2 ON public.pocede USING btree (idappli);


--
-- TOC entry 2810 (class 1259 OID 16537)
-- Name: pocede_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX pocede_pk ON public.pocede USING btree (idens, idappli);


--
-- TOC entry 2813 (class 1259 OID 16538)
-- Name: poste_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX poste_pk ON public.poste USING btree (idposte);


--
-- TOC entry 2816 (class 1259 OID 16539)
-- Name: statut_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX statut_pk ON public.statut USING btree (idstatut);


--
-- TOC entry 2821 (class 1259 OID 16540)
-- Name: transfere_fk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE INDEX transfere_fk ON public.transfert USING btree (iderreur);


--
-- TOC entry 2822 (class 1259 OID 16541)
-- Name: transfert_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX transfert_pk ON public.transfert USING btree (idadmin, iderreur);


--
-- TOC entry 2825 (class 1259 OID 16542)
-- Name: typeerreur_pk; Type: INDEX; Schema: public; Owner: postgres
--

CREATE UNIQUE INDEX typeerreur_pk ON public.typeerreur USING btree (idtype);


--
-- TOC entry 2826 (class 2606 OID 16543)
-- Name: affecter fk_affecter_affecter_admin; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.affecter
    ADD CONSTRAINT fk_affecter_affecter_admin FOREIGN KEY (idadmin) REFERENCES public.admin(idadmin) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2827 (class 2606 OID 16548)
-- Name: affecter fk_affecter_affecter_entrepri; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.affecter
    ADD CONSTRAINT fk_affecter_affecter_entrepri FOREIGN KEY (idens) REFERENCES public.entreprise(idens) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2828 (class 2606 OID 16553)
-- Name: commentaire fk_commenta_commenter_erreur; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT fk_commenta_commenter_erreur FOREIGN KEY (iderreur) REFERENCES public.erreur(iderreur) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2829 (class 2606 OID 16558)
-- Name: commentaire fk_commenta_commenter_membre; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.commentaire
    ADD CONSTRAINT fk_commenta_commenter_membre FOREIGN KEY (idmembre) REFERENCES public.membre(idmembre) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2830 (class 2606 OID 16563)
-- Name: employe fk_employe_associati_entrepri; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employe
    ADD CONSTRAINT fk_employe_associati_entrepri FOREIGN KEY (idens) REFERENCES public.entreprise(idens) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2831 (class 2606 OID 16568)
-- Name: employe fk_employe_associati_poste; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.employe
    ADD CONSTRAINT fk_employe_associati_poste FOREIGN KEY (idposte) REFERENCES public.poste(idposte) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2832 (class 2606 OID 16573)
-- Name: erreur fk_erreur_associati_admin; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.erreur
    ADD CONSTRAINT fk_erreur_associati_admin FOREIGN KEY (idadmin) REFERENCES public.admin(idadmin) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2833 (class 2606 OID 16578)
-- Name: erreur fk_erreur_associati_applicat; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.erreur
    ADD CONSTRAINT fk_erreur_associati_applicat FOREIGN KEY (idappli) REFERENCES public.application(idappli) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2834 (class 2606 OID 16583)
-- Name: erreur fk_erreur_associati_gravite; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.erreur
    ADD CONSTRAINT fk_erreur_associati_gravite FOREIGN KEY (idgravite) REFERENCES public.gravite(idgravite) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2835 (class 2606 OID 16588)
-- Name: erreur fk_erreur_associati_statut; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.erreur
    ADD CONSTRAINT fk_erreur_associati_statut FOREIGN KEY (idstatut) REFERENCES public.statut(idstatut) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2836 (class 2606 OID 16593)
-- Name: erreur fk_erreur_associati_typeerre; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.erreur
    ADD CONSTRAINT fk_erreur_associati_typeerre FOREIGN KEY (idtype) REFERENCES public.typeerreur(idtype) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2837 (class 2606 OID 16598)
-- Name: erreur fk_erreur_declarer_employe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.erreur
    ADD CONSTRAINT fk_erreur_declarer_employe FOREIGN KEY (idemp) REFERENCES public.employe(idemp) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2838 (class 2606 OID 16603)
-- Name: gerer fk_gerer_administr_admin; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gerer
    ADD CONSTRAINT fk_gerer_administr_admin FOREIGN KEY (idadmin) REFERENCES public.admin(idadmin) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2839 (class 2606 OID 16608)
-- Name: gerer fk_gerer_administr_applicat; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.gerer
    ADD CONSTRAINT fk_gerer_administr_applicat FOREIGN KEY (idappli) REFERENCES public.application(idappli) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2840 (class 2606 OID 16613)
-- Name: membre fk_membre_peuretre_admin; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membre
    ADD CONSTRAINT fk_membre_peuretre_admin FOREIGN KEY (idadmin) REFERENCES public.admin(idadmin) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2841 (class 2606 OID 16618)
-- Name: membre fk_membre_peutetre_employe; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.membre
    ADD CONSTRAINT fk_membre_peutetre_employe FOREIGN KEY (idemp) REFERENCES public.employe(idemp) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2842 (class 2606 OID 16623)
-- Name: piece fk_piece_associati_erreur; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.piece
    ADD CONSTRAINT fk_piece_associati_erreur FOREIGN KEY (iderreur) REFERENCES public.erreur(iderreur) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2843 (class 2606 OID 16628)
-- Name: pocede fk_pocede_pocede_applicat; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pocede
    ADD CONSTRAINT fk_pocede_pocede_applicat FOREIGN KEY (idappli) REFERENCES public.application(idappli) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2844 (class 2606 OID 16633)
-- Name: pocede fk_pocede_pocede_entrepri; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.pocede
    ADD CONSTRAINT fk_pocede_pocede_entrepri FOREIGN KEY (idens) REFERENCES public.entreprise(idens) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2845 (class 2606 OID 16638)
-- Name: transfert fk_transfer_associati_radmin; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transfert
    ADD CONSTRAINT fk_transfer_associati_radmin FOREIGN KEY (receveur) REFERENCES public.admin(idadmin) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2846 (class 2606 OID 16643)
-- Name: transfert fk_transfer_associati_tadmin; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transfert
    ADD CONSTRAINT fk_transfer_associati_tadmin FOREIGN KEY (idadmin) REFERENCES public.admin(idadmin) ON UPDATE RESTRICT ON DELETE RESTRICT;


--
-- TOC entry 2847 (class 2606 OID 16648)
-- Name: transfert fk_transfer_transfere_erreur; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.transfert
    ADD CONSTRAINT fk_transfer_transfere_erreur FOREIGN KEY (iderreur) REFERENCES public.erreur(iderreur) ON UPDATE RESTRICT ON DELETE RESTRICT;


-- Completed on 2021-06-09 19:57:05

--
-- PostgreSQL database dump complete
--

